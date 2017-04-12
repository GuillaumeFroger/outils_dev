package gf;

import java.io.*;
import java.util.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import com.opencsv.*;
import java.lang.*;
import static java.lang.Integer.parseInt;


public class App 
{
    public static int max(int a, int b){
		return a > b ? a : b;
    	//return a; // Erreur volontaire
    }
    
    public static void main( String[] args )
    {
        System.out.println( "max(5,4) : "+max(5, 4) );
        
        try{
            int monmax=0;
            CSVReader csvReader = new CSVReader(new FileReader("data.csv"));

            List<String[]> content = csvReader.readAll();
            
            Vector<String> out = new Vector<String>();
            CollectionUtils.select(content, new Predicate() {
	                public boolean evaluate(Object o) {
	                	String[] row = (String[]) o;
	                	try{
	                	return Integer.parseInt(row[0]) < 50;
	                	}
	                    catch (Exception e) {return false;}
					}
            												}, out);
            System.out.print("OUT:");

            String[] row;
            for (Object object : out) {
                row = (String[]) object;
                try{
                	monmax=max(monmax, Integer.parseInt(row[0]));
                	System.out.print(" "+Integer.parseInt(row[0]));
                }
                catch (Exception e) {};
            }
            csvReader.close();
            System.out.println("\nMax : "+monmax);
           
            //////////////////////////////////////////////// 
            
            CSVWriter writer = new CSVWriter(new FileWriter("data-filtered.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
            
            for (Object object : out) {
                row = (String[]) object;
                writer.writeNext(row);
            }
       	 	writer.close();
            
          }
          catch(FileNotFoundException e){}
          catch(IOException e){}
        
    }
    

}

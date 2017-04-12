package gf;

public class App 
{
    public static int max(int a, int b){
		return a > b ? a : b;
    	//return a; // Erreur volontaire
    }
    
    public static void main( String[] args )
    {
        System.out.println( "max(5,4) : "+max(5, 4) );
    }
    

}

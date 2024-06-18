/**
 * Excepcio2.java
 * Exemple de captura d'excepció a un altre mètode
 * @author Jose Moreno
 * @version 
 */
public class Excepcio2 {    
      public static void main(String[] args) {
        int x, y, z;
        
        x=10;
        y=0;
        try{
        	z = f(x,y);  //aqui es produeix una divisió per zero
        }
        catch (ArithmeticException ae) {
        	System.out.println("Error en dividir: " + ae.getMessage());
        }
    }
    public static int f(int a, int b) throws ArithmeticException {
    	return a/b;
    }
}
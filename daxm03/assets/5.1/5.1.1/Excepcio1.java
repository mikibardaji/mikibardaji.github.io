/**
 * Excepcio1.java
 * Exemple de captura d'excepció al mateix mòdul
 * @author Jose Moreno
 * @version 
 */
public class Excepcio1 {    
      public static void main(String[] args) {
        int x, y, z;
        
        x=10;
        y=0;
        try{
        	z = x/y;  //aqui es produeix una divisió per zero
        }
        catch (ArithmeticException ae) {
        	System.out.println("Error en dividir: " + ae.getMessage());
        }
    }
}
import java.util.Scanner;  // Import the Scanner class
import java.util.InputMismatchException; // Import exception
import java.lang.Exception;
/**
 * Handling several exceptions.
 * This class executes a division of 2 integers (numerator and 
 * denomintaro) and assign its result to an item of an integer array. 
 * Numerator, denominator and array index
 * has been entered by user.
 * @author ProvenSoft
 * @version 1.0
 */
public class Exception3 {   
	
	private int numerator;
	private int denominator;
	private int result;
	private int index;
	private int[] array;
			
      public static void main(String[] args) {			  
		Exception3 myApp = new Exception3 (); 
		myApp.run();  
    }
    
    public void run() {
		array = new int[5]; // Initialize array
		// Read input parameters
		inputData();	
		// Execute function
		try{
			result = fDivide(numerator, denominator);
			fAssign(result,index);
			// Reports result
			System.out.format ("Array [%d] = %d\n", index, result);
		}
		
		catch (IndexOutOfBoundsException iobe){
			System.out.println ("Out of bounds: " + iobe.getMessage());
		}
		catch (ArithmeticException ae){
			System.out.println ("Arithmetic error: " +ae.getMessage());
		}
		/**
		// Catch for handling More Than One Type of Exception
		catch (IndexOutOfBoundsException | ArithmeticException exc){
			exc.printStackTrace();
		}
		*/
		finally {
			array = null;
			System.out.println ("Bye!");
		}
						
	}
    
    public void inputData() {
		Scanner sc = new Scanner(System.in);
		try{
			
			System.out.print ("Input numerator: ");
			numerator=sc.nextInt();
			System.out.print ("Input denominator: ");
			denominator=sc.nextInt();
			System.out.print ("Input index: ");
			index=sc.nextInt();
		}
		catch (InputMismatchException ime){
			System.out.println ( "Wrong input value: " + ime.getMessage());
			ime.printStackTrace();
		}
	}
    
    public int fDivide(int a, int b) throws ArithmeticException {
    	return a/b;
    }
    
    public void fAssign (int value, int pos) throws IndexOutOfBoundsException {
	 array[pos] = value;
     }
}


import java.util.Scanner;

public class MyFirstDemoClass1 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
	      
		int number1;
	    
		System.out.println("Enter the number : ");
	      
		number1=Integer.parseInt(scanner.next());
	       
	       
	
	
		if (number1>0) {
			System.out.println("The number is positive");
		}
		else {
			   if (number1==0) {
				   System.out.println("The number is equal to 0");
			   }
			   else {
				   System.out.println("The number is negative ");
			   }
		}
       
	}

}

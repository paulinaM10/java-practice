import java.util.Scanner;


/*
 * Area of Rectangle = length of Rectangle * breadth of rectangle 
 */

public class UserInputDemoOne {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
	
	
		System.out.println("Enter the first value: ");
		int value=Integer.parseInt(scanner.next());
		
	
		System.out.println("Enter second value: ");
		int value2=Integer.parseInt(scanner.next());
		
		System.out.println("First value: "+value +", Second value: " + value2);
		
		int value3 = value;
		int value4 = value2;
		
		
		System.out.println("First value: "+value4 +", Second value: " + value3);

		
		

	}

}

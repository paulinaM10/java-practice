
import java.util.Scanner;

public class MyFirstDemoClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number: ");
        int number = scanner.nextInt();
        int originalNumber = number;
        int reverse = 0;

        while(number != 0) {
            int digit = number % 10;  
            reverse = reverse * 10 + digit;  
            number = number / 10;  
        }

        if (originalNumber == reverse) {
            System.out.println("The number is a mirrored number.");
        } else {
            System.out.println("The number is not a mirrored number.");
        }

        System.out.println("The reversed number is: " + reverse);
    }
}

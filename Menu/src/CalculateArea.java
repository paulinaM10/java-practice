
import java.util.Scanner;

public class CalculateArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		int selectedNumber;
		String choice;

		do {
			System.out.println("Select the number from the menu :1. Calculate Area of Rectangle\n"
					+ "2. Calculate Area of Circle\n" + "3. Calculate Area of Triangle\n"
					+ "4. Calculate Area of Square\n" + "5. Exit");
			selectedNumber = scanner.nextInt();

			switch (selectedNumber) {
			case 1:
				System.out.println("Enter the length : ");
				int length = scanner.nextInt();
				System.out.println("Enter the width : ");
				int width = scanner.nextInt();

				int result = length * width;
				System.out.println("Area of the Rectangle : " + result);
				break;

			case 2:
				System.out.println("Enter the radius : ");
				int radius = scanner.nextInt();

				double piNum = 3.14f;

				double resultCircle = piNum * radius * radius;
				System.out.println("Area of the Circle : " + resultCircle);
				break;
			case 3:
				System.out.println("Enter the hight : ");
				int hight = scanner.nextInt();
				System.out.println("Enter the base : ");
				int base = scanner.nextInt();

				int resultTriangle = (hight * base) / 2;
				System.out.println("Area of the Traingle : " + resultTriangle);
				break;
			case 4:
				System.out.println("Enter the side : ");
				int side = scanner.nextInt();

				int resultSquare = side * side;
				System.out.println("Area of the Square : " + resultSquare);
				break;
			case 5:
				System.out.println("Hava a nice day!");
				System.exit(0);
				break;

			default:
				System.out.println("invalid number");
			}
			System.out.println("Do you wish to continue?");
			choice = scanner.next();

		} while (choice.equalsIgnoreCase("y"));
		System.out.println("Good Bye, Have a Nice Day!");

	}
}

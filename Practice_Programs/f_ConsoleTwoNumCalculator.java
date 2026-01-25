package Practice_Programs;
import java.util.Scanner;

public class f_ConsoleTwoNumCalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = s.nextDouble();

        System.out.print("\nEnter the second number: ");
        double num2 = s.nextDouble();

        System.out.print("\nEnter the operator (+, -, /, *): ");
        String operator = s.next();

        switch(operator) {
            case "+" -> System.out.printf("\nThe sum is %f", num1 + num2);
            case "-" -> System.out.printf("\nThe difference is %f", num1 - num2);
            case "*" -> System.out.printf("\nThe product is %f", num1 * num2);
            case "/" -> System.out.print((num2 != 0) ? "\nThe quotient is "+ (num1 / num2) : "Invalid number 1, it cannot be 0.");
            default -> System.out.print("\nInvalid operator.");
        }

        s.close();
    }
}

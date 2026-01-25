package Practice_Programs;
import java.util.Scanner;

public class d_WeightConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the weight converter. Please enter either of the following options:\n" +
                "1. Pounds to Kilograms (1)\n" +
                "2. Kilograms to pounds (2)");
        String Choice = scanner.nextLine();

        System.out.print("Enter the given weight: ");
        double given = scanner.nextDouble();

        scanner.close();

        if (Choice.equalsIgnoreCase("1")) {
            System.out.println("You chose option 1. (Pounds to kilograms).");
            System.out.printf("The weight in kilograms will be %.2f.\n", given * 0.453592);
        }
        else if (Choice.equalsIgnoreCase("2")) {
            System.out.println("You chose option 2. (Kilograms to pounds).");
            System.out.printf("The weight in pounds will be %.2f.\n", given / 0.453592);
        }
        else {
            System.out.println("You must choose a valid option!");
        }
        System.out.print("Thank you for using our platform.");
    }
}

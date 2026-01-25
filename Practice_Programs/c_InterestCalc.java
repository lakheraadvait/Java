package Practice_Programs;
import java.util.Scanner;

public class c_InterestCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter annual interest rate (in %): ");
        double rate = scanner.nextDouble() / 100;

        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();

        System.out.print("Enter number of times interest is compounded per year: ");
        int timesCompounded = scanner.nextInt();

        double amount = principal * Math.pow(1 + (rate / timesCompounded), timesCompounded * years);
        double interest = amount - principal;

        System.out.println("Final amount: " + amount);
        System.out.println("Total compound interest: " + interest);

        scanner.close();
    }
}

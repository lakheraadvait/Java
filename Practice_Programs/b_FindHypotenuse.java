package Practice_Programs;
import java.util.Scanner;

public class b_FindHypotenuse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of the first side (base): ");
        float side1 = scanner.nextFloat();

        System.out.print("Enter the value of the second side (perpendicular): ");
        float side2 = scanner.nextFloat();

        scanner.close();

        float side3 = (float) Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
        System.out.println("Hypotenuse is: " + side3);
    }
}

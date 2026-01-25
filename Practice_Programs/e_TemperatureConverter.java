package Practice_Programs;
import java.util.Scanner;

public class e_TemperatureConverter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the temperature to convert: ");
        double temp = s.nextDouble();

        System.out.println("Choose either of the following options: \n" +
                "1. Fahrenheit to Celsius (1) \n" +
                "2. Celsius to Fahrenheit (2) ");
        s.nextLine();
        String choice = s.nextLine();

        double ans = (choice.equals("1")) ? ((temp - 32)*(5.0/9)) : ((temp * (9.0/5)) + 32);
        String degree = (choice.equals("1")) ? "celsius" : "fahrenheit";

        System.out.printf("The temperature in %s will  be %.2f.", degree, ans);

        s.close();
    }
}

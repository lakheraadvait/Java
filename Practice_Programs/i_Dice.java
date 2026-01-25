package Practice_Programs;
import java.util.Random;
import java.util.Scanner;

public class i_Dice {

    public static void main(String[] args) {
        int die = 0;
        int total = 0;
        Random r = new Random();
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of die: ");
        die = s.nextInt();
        while (die <= 0) {
            System.out.println("\nNumber of die must be greater than 0!");
            System.out.print("Enter the number of die: ");
            die = s.nextInt();
        }

        for (int i = 1; i <= die; i ++) {
            int roll = r.nextInt(6) + 1;
            showDice(roll);
            total += roll;
        }
        System.out.println("The total is " + total + ".");

    }

    static void showDice(int roll) {
        switch (roll) {
            case 1 -> {
                System.out.println("┌─────┐");
                System.out.println("│     │");
                System.out.println("│  ●  │");
                System.out.println("│     │");
                System.out.println("└─────┘");
            }
            case 2 -> {
                System.out.println("┌─────┐");
                System.out.println("│ ●   │");
                System.out.println("│     │");
                System.out.println("│   ● │");
                System.out.println("└─────┘");
            }
            case 3 -> {
                System.out.println("┌─────┐");
                System.out.println("│ ●   │");
                System.out.println("│  ●  │");
                System.out.println("│   ● │");
                System.out.println("└─────┘");
            }
            case 4 -> {
                System.out.println("┌─────┐");
                System.out.println("│ ● ● │");
                System.out.println("│     │");
                System.out.println("│ ● ● │");
                System.out.println("└─────┘");
            }
            case 5 -> {
                System.out.println("┌─────┐");
                System.out.println("│ ● ● │");
                System.out.println("│  ●  │");
                System.out.println("│ ● ● │");
                System.out.println("└─────┘");
            }
            case 6 -> {
                System.out.println("┌─────┐");
                System.out.println("│ ● ● │");
                System.out.println("│ ● ● │");
                System.out.println("│ ● ● │");
                System.out.println("└─────┘");
            }
        }
    }

}

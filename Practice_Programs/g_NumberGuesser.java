package Practice_Programs;
import java.util.Scanner;
import java.util.Random;

public class g_NumberGuesser {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int bound = 10;
        int num = random.nextInt(1, bound + 1);
        int guess = 0;
        int tries = 0;

        System.out.println("We are going to play a number guessing game!");

        while (guess != num) {
            System.out.println("Tries: " + tries);
            System.out.printf("\nEnter a number from 1 to %d: ", bound);
            guess = scanner.nextInt();
            if (guess < num && guess <= bound && guess >= 1) {
                System.out.println("Higher kid, higher!");
                tries++;
            }
            else if (guess > num && guess <= bound && guess >= 1) {
                System.out.println("Lower kid, lower!");
                tries++;
            }
            else if (guess == num) {
                tries++;
                break;
            }
            else {
                System.out.printf("\nYou must enter a number greater than 0 but less than or equal to %d.\n", bound);
            }
        }

        System.out.printf("\nYou did it kid! You won! It only took you %d tries!", tries);
    }
}

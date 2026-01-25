package Practice_Programs;
import java.util.Scanner;

public class h_BankingProgram {

    static int Balance;
    static String Cont = "";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (Cont.isEmpty()) {
            System.out.println("Good day sir, please choose an option below, you currently have " + "£" + Balance + ".");
            System.out.println("1. Deposit an amount");
            System.out.println("2. Withdraw an amount");
            System.out.println("3. Quit");
            int choice = s.nextInt();
            while (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("You must pick either 1, 2 or 3!");
                choice = s.nextInt();
            }
            switch (choice) {
                case 1 -> Deposit();
                case 2 -> Withdraw();
                case 3 -> Quit();
            }


        }
        System.out.println("Thank you for using our bank!");
        s.close();
    }

    static void Deposit() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an amount to deposit: ");
        Balance += s.nextInt();
        System.out.println("The amount has been added to your balance\n");
    }

    static void Withdraw() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an amount to withdraw: ");
        Balance -= s.nextInt();
        System.out.println("The amount has been deducted from your balance\n");
    }

    static void Quit() {
        Cont = " eee";
    }
}

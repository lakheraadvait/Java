import java.util.Scanner;

public class m_WhileLoops {
    public static void main(String[] args) {
        // While loops
        Scanner s = new Scanner(System.in);

        String name = "";
        int age = -1;

        while(name.isEmpty()) {
            System.out.print("Enter your name: ");
            name = s.nextLine();
        }

        System.out.printf("\nHello %s.\n", name);

        // Do while loops

        do {
            System.out.println("Your age cannot be negative!");
            System.out.print("Enter your age: ");
            age = s.nextInt();
        }while (age < 0);

        System.out.printf("\nYou are %d years old!", age);
    }
}

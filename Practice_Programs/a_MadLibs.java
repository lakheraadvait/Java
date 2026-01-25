package Practice_Programs;
import java.util.Scanner;

public class a_MadLibs {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.print("Enter an adjective: ");
       String adj1 = scanner.nextLine();

       System.out.print("Enter a verb: ");
       String verb1 = scanner.nextLine();

       System.out.print("Enter a noun: ");
       String noun1 = scanner.nextLine();

       System.out.print("Enter another adjective: ");
       String adj2 = scanner.nextLine();

       System.out.print("Enter one last adjective: ");
       String adj3 = scanner.nextLine();

       scanner.close();

       System.out.println("Today, I went to a " + adj1 + " zoo.");
       System.out.println("At the zoo, I met a " + noun1 + ".");
       System.out.println("It was extremely " + adj2 + ".");
       System.out.println("The " + noun1 + " was very " + adj3 + " and " + verb1 + ".");
   }
}

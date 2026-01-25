public class e_Conditionals {
    public static void main(String[] args) {
        boolean test = false;

        if (test) { // && is and, || is or and ! is not
            System.out.println("The test boolean has been set to true.");
        }

        else if (test == false){
            System.out.println("The test boolean has been set to false.");
        }

        else {
            System.out.println("You can never see this message.");
        }
    }
}

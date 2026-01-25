public class k_TernaryOperators {
    public static void main(String[] args) {
        // variable = (condition) ? ifTrue : ifFalse
        // Ternary operator is a shorter version of if statement
        int marks = 23; // (out of 80)
        String passOrFail = (marks >= 33) ? "pass" : "fail";
        System.out.printf("You have %sed.", passOrFail);
    }
}

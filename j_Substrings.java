public class j_Substrings {
    public static void main(String[] args){

        String email = "advaitlakhera@gmail.com";
        // Stores an email address as a String

        String user = email.substring(0, email.indexOf("@"));
        // Extracts the username part (everything before '@')

        String domain = email.substring(email.indexOf("@") + 1, email.length());
        // Extracts the domain part (everything after '@')

        System.out.printf("Hello %s. You are using %s.", user, domain);
        // Prints a formatted message inserting the username and domain
    }
}

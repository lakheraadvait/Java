public class i_StringMethods {
    public static void main(String[] args) {

        String stringer = "        Test stringering       ";
        // Creates a String with leading and trailing spaces

        int length = stringer.length();
        // Returns the total number of characters in the string (including spaces)

        char letter = stringer.charAt(0);
        // Gets the character at index 0 (first character, which is a space here)

        int index = stringer.indexOf("s");
        // Finds the index of the first occurrence of "s" (-1 if not found)

        stringer = stringer.toUpperCase();
        // Converts all characters in the string to uppercase

        stringer = stringer.trim();
        // Removes leading and trailing whitespace from the string

        stringer = stringer.replace("s", "a");
        // Replaces all occurrences of "s" with "a"

        stringer.isEmpty();
        // Checks if the string is empty (length == 0), returns true or false

        stringer.contains(" ");
        // Checks if the string contains a space character, returns true or false

        stringer.equalsIgnoreCase("EWOA");
        // Compares the string to "EWOA" ignoring letter case, returns true or false
    }
}

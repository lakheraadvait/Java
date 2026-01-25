import java.util.Arrays;          // Provides utility methods for arrays (sorting, filling, etc.)
import java.util.Comparator;      // Used to define custom sorting logic (like reverse order)

class r_Arrays {
    public static void main(String[] args) {

        // String array to store fruit names
        String[] fruits = {"Banana", "Orange", "Apple", "Pineapple"};

        // Integer array to store numbers
        int[] nums = {1, 2, 3, 4};

        // Assigns "Banana" to index 0 of the fruits array
        fruits[0] = "Banana";
        System.out.println(fruits[0]); // Prints the value at index 0

        // Reassigns a new value to index 0
        fruits[0] = "GULGUGUL";
        System.out.println(fruits[0]); // Prints updated value

        // Prints the first element of nums array
        System.out.println(nums[0]);

        // Sorts the fruits array in reverse alphabetical order
        Arrays.sort(fruits, Comparator.reverseOrder());

        // Replaces every element in the fruits array with the string "1"
        Arrays.fill(fruits, "1");

        // Loop to print all elements of the fruits array
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }
    }
}

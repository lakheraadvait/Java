import java.util.Arrays;      // (Not used here) Provides utility methods for arrays
import java.util.Comparator;  // (Not used here) Used for custom sorting logic

class s_VarArgs {
    public static void main(String[] args) {

        // Calls the add() method with a variable number of arguments
        // All values are automatically packed into an int[] array
        System.out.println(add(1, 2, 3, 4, 5, 6, 7, 2, 1, 2, 3));
    }

    // Varargs method: allows passing any number of int arguments
    // Internally, Java treats 'numbers' as an int array
    static int add(int... numbers) {
        int sum = 0; // Stores the cumulative sum of all numbers

        // Enhanced for-loop to iterate through the numbers array
        for (int num : numbers) {
            sum += num; // Adds each number to sum
        }

        // Returns the final calculated sum
        return sum;
    }
}

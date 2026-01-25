public class o_BreakContinue {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++) {  // For loops for repeating a certain amount of time
            if (i == 5) {
                continue; // Break will stop, continue will skip to next cycle
            }
            System.out.println(i);
        }
    }
}

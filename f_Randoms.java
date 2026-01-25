import java.util.Random;
public class f_Randoms {
    public static void main(String[] args) {
        Random random = new Random();
        boolean test_bool = random.nextBoolean();
        int test_int = random.nextInt(1, 6 + 1); // You can get the origin but not the bound

        System.out.println(test_bool);
        System.out.println(test_int);
    }
}

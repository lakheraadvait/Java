class p_Methods {
    public static void main(String[] args) {
        HappyBirthday(5, "Advait");
        System.out.println(square(2, 3));
    }

    static void HappyBirthday(int n, String name) {
        for (int i = 0; i <= n; i++) {
            System.out.printf("Happy Birthday %s!\n", name);
        }
    }

    static double square(int number) {
        return (number * number);
    }

    static double square(int number, int times) { //overloaded method
        double n = number;
        for (int i = 1; i <= times; i++) {
            n = square((int) n);
        }
        return n;
    }
}

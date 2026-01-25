class t_2DArrays {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana", "Orange"};
        String[] veggies = {"Carrot", "Radish", "Potato"};
        String[] meats = {"Lamb", "Chicken", "Mutton"};

        String[][] groceries = {fruits, veggies, meats};

        for (String[] grocery : groceries) {
            for (String item : grocery) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}

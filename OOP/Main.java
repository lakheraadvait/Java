package OOP;

class Main {
    public static void main(String[] args) {
        Car car = new Car("Focus",
        "Silver",
                "Ford",
                2025,
                32000.00
        );


        System.out.printf("%s %s %s %d for sale at %f!%n", car.colour, car.make, car.model, car.year, car.price);
        car.rev();
    }
}

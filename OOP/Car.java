package OOP;

public class Car {
    String make = "Ford";
    String colour = "Blue";
    String model = "Fira";
    int year = 2014;
    double price = 3234.32;

    static void rev() {
        System.out.println("The car revs... rrrrrrrrrrrr... rrrrrrrevvvvvvvvvv!");
    }

    Car(String make, String colour, String model, int year, double price) {
        this.make = make;
        this.colour = colour;
        this.model = model;
        this.year = year;
        this.price = price;
    }
}

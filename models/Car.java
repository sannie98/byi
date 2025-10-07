// Car.java
package models;

public class Car {
    public int year;
    public int horsePower;
    public String brand;

    public Car(int year, int horsePower, String brand) {
        this.year = year;
        this.horsePower = horsePower;
        this.brand = brand;
    }

    public void drive() {
        System.out.println(brand + " Едет");
    }

    public void stop() {
        System.out.println(brand + " Остановка");
    }
}
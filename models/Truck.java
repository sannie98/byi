package models;

public class Truck extends Car {
    public int loadCapacity;

    public Truck(int year, int horsePower, String brand, int loadCapacity) {
        super(year, horsePower, brand);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void drive() {
        System.out.println("Грузовик " + brand + " едет");
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
package models;

public class Sedan extends Car {
    int passCount;

    public Sedan(int year, int horsePower, String brand, int passCount) {
        super(year, horsePower, brand);
        this.passCount = passCount;
    }
}
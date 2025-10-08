package models;

public class ElectroCar extends Car {
    public int batteryCapacity;

    public ElectroCar(int year, int horsePower, String brand, int batteryCapacity) {
        super(year, horsePower, brand);
        this.batteryCapacity = batteryCapacity;
    }

    public ElectroCar(int year, int horsePower, String brand, int batteryCapacity, boolean move, int idx) {
        super(year, horsePower, brand);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(brand + " заряжен на " + batteryCapacity +"%");
    }

    public void getBrand() {
    }

    public Object getYear() {
        return null;
    }

    public Object getBatteryCapacity() {
        return null;
    }
}
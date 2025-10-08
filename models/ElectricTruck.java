package models;

public class ElectricTruck extends ElectroCar {
    int loadCapacity;

    public ElectricTruck(int year, int horsePower, String brand, int batteryCapacity, int loadCapacity) {
        super(year, horsePower, brand, batteryCapacity);
        this.loadCapacity = loadCapacity;
        System.out.println("загрузка на " + loadCapacity);
    }
}
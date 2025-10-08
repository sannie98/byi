package models;

public class Main {
    public static void main(String[] args) {
        Sedan sedan1 = new Sedan(2015, 160, "Toyota", 4);
        sedan1.drive();

        Sedan sedan2 = new Sedan(2010, 240, "Porshe", 2);

        ElectroCar electro1 = new ElectroCar(2010, 240, "Tesla", 88);

        sedan2.drive();
        sedan2.stop();
        electro1.charge();

        Sedan[] sedans = {sedan1, sedan2};

        for (int i = 0; i < sedans.length; i++) {
            sedans[i].drive();
        }

        testRepo();
    }

    static void testRepo() {
        System.out.println("**test**");

        repository.CarRepository repo = new repository.CarRepository();
        Car car1 = new Car(2020, 150, "Toyota");
        repo.save(car1);

        System.out.println("Total cars: " + repo.count());

        repo.deleteAll();

        System.out.println("Total cars after deletion: " + repo.count());

        carOperations();
    }

    static void carOperations() {
        System.out.println("\n--- Демонстрация различных автомобилей ---");

        Car car1 = new Car(2020, 150, "Toyota");
        Car car2 = new Car(2021, 200, "Porshe");
        ElectroCar car3 = new ElectroCar(2022, 300, "Tesla", 100);
        Sedan car4 = new Sedan(2020, 180, "Toyota", 4);
        Truck car5 = new Truck(2021, 250, "KAMAZ", 5000);
        Truck car6 = new Truck(2022, 280, "JIP", 6000);

        car1.drive();
        car2.drive();
        car3.drive();
        car4.drive();
        car5.drive();
        car6.drive();
    }
}
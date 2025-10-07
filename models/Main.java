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

        System.out.println("Total cars after deletion: 0");

        testElectroRepo();
    }

    static void testElectroRepo() {
        System.out.println("\n**mm Testing ElectroCarRepository mm**");

        repository.ElectroCarRepository electroRepo = new repository.ElectroCarRepository();

        ElectroCar e1 = new ElectroCar(2022, 300, "Tesla", 100);
        ElectroCar e2 = new ElectroCar(2023, 250, "Nissan", 80);
        ElectroCar e3 = new ElectroCar(2022, 280, "Tesla", 60);

        electroRepo.save(e1);
        electroRepo.save(e2);
        electroRepo.save(e3);

        System.out.println("Total electro cars: 3");

        var found = electroRepo.findByBrand("Tesla");
        if (!found.isEmpty()) {
            System.out.println("Found electro car: Tesla");
            found.get(0).drive();
        }

        System.out.println("Electro exists ID 1: true");

        var batteryCars = electroRepo.findByMinBatteryCapacity(70);
        System.out.println("Cars with battery >= 70: 2");

        electroRepo.deleteAll();
        System.out.println("Deleted all 3 electro cars from repository");
        System.out.println("Total electro cars after deleted!!: 0");

        carOperations();
    }

    static void carOperations() {
        System.out.println("\n**mm Car Operations mm**");

        Car car1 = new Car(2020, 150, "Toyota");
        Car car2 = new Car(2021, 200, "Porshe");
        ElectroCar car3 = new ElectroCar(2022, 300, "Tesla", 100);
        Sedan car4 = new Sedan(2020, 180, "Toyota", 4);
        Truck car5 = new Truck(2021, 250, "Jundia", 5000);
        Truck car6 = new Truck(2022, 280, "BIM", 6000);

        car1.drive();
        car2.drive();
        car3.drive();
        car4.drive();
        car5.drive();
        car6.drive();
    }
}
package repositories;

import models.Car;
import models.CarBrand;

interface repository {
    void addCar(Car car);
    void delCar(int ind);
    void getCar(String brand);
    void getCars(CarBrand brands);
}
package repository;

import models.Car;
import java.util.*;

public class CarRepository implements Repository<Car, Integer> {
    private List<Car> cars = new ArrayList<>();
    private int nextId = 1;

    @Override
    public Car save(Car entity) {
        if (entity != null) {
            cars.add(entity);
            nextId++;
            return entity;
        }
        return null;
    }

    @Override
    public List<Car> saveAll(Collection<Car> entities) {
        List<Car> savedCars = new ArrayList<>();
        for (Car car : entities) {
            savedCars.add(save(car));
        }
        return savedCars;
    }

    @Override
    public Optional<Car> findById(Integer id) {
        if (id >= 1 && id <= cars.size()) {
            return Optional.of(cars.get(id - 1));
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {
        if (id >= 1 && id <= cars.size()) {
            cars.remove(id - 1);
            nextId--;
        }
    }

    @Override
    public void deleteAll() {
        cars.clear();
        nextId = 1;
    }

    @Override
    public long count() {
        return cars.size();
    }

    @Override
    public boolean existsById(Integer id) {
        return id >= 1 && id <= cars.size();
    }

    public List<Car> findByBrand(String brand) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.brand.equalsIgnoreCase(brand)) {
                result.add(car);
            }
        }
        return result;
    }

    public List<Car> findAll() {
        return new ArrayList<>(cars);
    }
}
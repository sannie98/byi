package repository;

import models.Car;
import java.util.*;

public class CarRepository implements Repository<Car, Integer> {
    private Map<Integer, Car> cars = new HashMap<>();
    private int nextId = 1;

    @Override
    public Car save(Car entity) {
        if (entity != null) {
            cars.put(nextId++, entity);
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
        return Optional.ofNullable(cars.get(id));
    }

    @Override
    public void deleteById(Integer id) {
        cars.remove(id);
    }

    @Override
    public void deleteAll() {
        cars.clear();
    }

    @Override
    public long count() {
        return cars.size();
    }

    @Override
    public boolean existsById(Integer id) {
        return cars.containsKey(id);
    }

    public List<Car> findByBrand(String brand) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars.values()) {
            if (car.brand.equalsIgnoreCase(brand)) {
                result.add(car);
            }
        }
        return result;
    }

    public List<Car> findAll() {
        return new ArrayList<>(cars.values());
    }
}
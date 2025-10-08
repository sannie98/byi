package repository;

import models.ElectroCar;
import java.util.*;

public class ElectroCarRepository implements Repository<ElectroCar, Integer> {
    private List<ElectroCar> electroCars = new ArrayList<>();
    private int nextId = 1;

    @Override
    public ElectroCar save(ElectroCar entity) {
        if (entity != null) {
            electroCars.add(entity);
            nextId++;
            return entity;
        }
        return null;
    }

    @Override
    public List<ElectroCar> saveAll(Collection<ElectroCar> entities) {
        List<ElectroCar> savedCars = new ArrayList<>();
        for (ElectroCar car : entities) {
            savedCars.add(save(car));
        }
        return savedCars;
    }

    @Override
    public Optional<ElectroCar> findById(Integer id) {
        if (id >= 1 && id <= electroCars.size()) {
            return Optional.of(electroCars.get(id - 1));
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {
        if (id >= 1 && id <= electroCars.size()) {
            electroCars.remove(id - 1);
            nextId--;
        }
    }

    @Override
    public void deleteAll() {
        electroCars.clear();
        nextId = 1;
    }

    @Override
    public long count() {
        return electroCars.size();
    }

    @Override
    public boolean existsById(Integer id) {
        return id >= 1 && id <= electroCars.size();
    }

    public List<ElectroCar> findByMinBatteryCapacity(int minCapacity) {
        List<ElectroCar> result = new ArrayList<>();
        for (ElectroCar car : electroCars) {
            if (car.batteryCapacity >= minCapacity) {
                result.add(car);
            }
        }
        return result;
    }

    public List<ElectroCar> findByBrand(String brand) {
        List<ElectroCar> result = new ArrayList<>();
        for (ElectroCar car : electroCars) {
            if (car.brand.equalsIgnoreCase(brand)) {
                result.add(car);
            }
        }
        return result;
    }

    public List<ElectroCar> findAll() {
        return new ArrayList<>(electroCars);
    }
}
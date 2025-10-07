package repository;

import models.ElectroCar;
import java.util.*;

public class ElectroCarRepository implements Repository<ElectroCar, Integer> {
    private Map<Integer, ElectroCar> electroCars = new HashMap<>();
    private int nextId = 1;

    @Override
    public ElectroCar save(ElectroCar entity) {
        if (entity != null) {
            electroCars.put(nextId++, entity);
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
        return Optional.ofNullable(electroCars.get(id));
    }

    @Override
    public void deleteById(Integer id) {
        electroCars.remove(id);
    }

    @Override
    public void deleteAll() {
        electroCars.clear();
    }

    @Override
    public long count() {
        return electroCars.size();
    }

    @Override
    public boolean existsById(Integer id) {
        return electroCars.containsKey(id);
    }

    public List<ElectroCar> findByMinBatteryCapacity(int minCapacity) {
        List<ElectroCar> result = new ArrayList<>();
        for (ElectroCar car : electroCars.values()) {
            if (car.batteryCapacity >= minCapacity) {
                result.add(car);
            }
        }
        return result;
    }

    public List<ElectroCar> findByBrand(String brand) {
        List<ElectroCar> result = new ArrayList<>();
        for (ElectroCar car : electroCars.values()) {
            if (car.brand.equalsIgnoreCase(brand)) {
                result.add(car);
            }
        }
        return result;
    }

    public List<ElectroCar> findAll() {
        return new ArrayList<>(electroCars.values());
    }
}
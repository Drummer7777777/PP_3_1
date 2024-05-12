package ru.ponomarev.SpringBoot.service;

import org.springframework.stereotype.Service;
import ru.ponomarev.SpringBoot.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    private List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        Car car1 = new Car("Lada", "Granta", 222);
        Car car2 = new Car("Lada", "Vesta", 333);
        Car car3 = new Car("Lada", "Largus", 444);
        Car car4 = new Car("Lada", "Niva", 555);
        Car car5 = new Car("Lada", "Xray", 666);
        this.cars.add(car1);
        this.cars.add(car2);
        this.cars.add(car3);
        this.cars.add(car4);
        this.cars.add(car5);
    }

    @Override
    public List<Car> getCars(int count) {
        if (count>5) {
            count = 5;
        }
        List<Car> response_car = new ArrayList<>();
        for (int i=0; i<count; i++) {
            response_car.add(this.cars.get(i));
        }
        return response_car;
    }
}

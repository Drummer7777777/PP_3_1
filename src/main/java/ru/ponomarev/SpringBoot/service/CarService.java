package ru.ponomarev.SpringBoot.service;


import ru.ponomarev.SpringBoot.models.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars(int count);
}

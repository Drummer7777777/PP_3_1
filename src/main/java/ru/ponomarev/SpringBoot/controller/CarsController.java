package ru.ponomarev.SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ponomarev.SpringBoot.models.Car;
import ru.ponomarev.SpringBoot.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam(defaultValue = "5", name = "count") int count) {
        List<Car> carsResponse = new ArrayList<>(carService.getCars(count));
        model.addAttribute("cars" , carsResponse);
        return "cars";
    }

}

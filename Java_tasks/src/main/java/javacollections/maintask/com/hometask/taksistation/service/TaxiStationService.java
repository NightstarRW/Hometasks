package javacollections.maintask.com.hometask.taksistation.service;

import javacollections.maintask.com.hometask.taksistation.entity.Car;
import javacollections.maintask.com.hometask.taksistation.entity.TaxiStation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Taxi Station Service class.
 *
 * @author Makism Sereda
 * @version 1.0 17.12.2020
 */
public class TaxiStationService {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * This method gets total cars cost.
     */
    public static int getTotalCarsCost(TaxiStation taxiStation) {
        int totalPrice = 0;
        for (Car car : taxiStation.getCars()) {
            totalPrice += car.getPrice();
        }
        return totalPrice;
    }

    /**
     * This method founds cars by max speed.
     */
    public static List<Car> sortByMaxSpeed(TaxiStation taxiStation) {
        List<Car> carsWithMaxSpeed = new ArrayList<>();
        System.out.println("Enter max speed: ");
        int maxSpeed = SCANNER.nextInt();
        for (Car car : taxiStation.getCars()) {
            if (car.getMaxSpeed() >= maxSpeed) {
                carsWithMaxSpeed.add(car);
            }
        }
        if (carsWithMaxSpeed.isEmpty()) {
            System.out.println("No cars with such max speed");
        }
        return carsWithMaxSpeed;
    }

    /**
     * This method sorts cars by fuel consumption.
     */
    public static List<Car> sortByFuelConsumption(TaxiStation taxiStation) {
        List<Car> sortedCars = taxiStation.getCars();
        sortedCars.sort(Comparator.comparingInt(Car::getFuelConsumption));
        return sortedCars;
    }
}
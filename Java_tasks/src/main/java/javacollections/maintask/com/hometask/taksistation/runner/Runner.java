package javacollections.maintask.com.hometask.taksistation.runner;

import javacollections.maintask.com.hometask.taksistation.entity.Car;
import javacollections.maintask.com.hometask.taksistation.entity.CompanyCar;
import javacollections.maintask.com.hometask.taksistation.entity.OwnerCar;
import javacollections.maintask.com.hometask.taksistation.entity.TaxiStation;
import javacollections.maintask.com.hometask.taksistation.service.TaxiStationService;
import javacollections.maintask.com.hometask.taksistation.types.CompanyCarType;
import javacollections.maintask.com.hometask.taksistation.types.RentType;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class runs application.
 *
 * @author Makism Sereda
 * @version 1.0 17.12.2020
 */
public class Runner {
    public static final List<Car> CARS = Arrays.asList(
            new CompanyCar(1, "Renault Logan", "white", "o123cs", 23000, 230, 10, 4, "manual", CompanyCarType.ECONOMIC, RentType.DAILY),
            new CompanyCar(2, "Renault Logan", "white", "i222as", 23000, 230, 10, 4, "manual", CompanyCarType.ECONOMIC, RentType.DAILY),
            new CompanyCar(3, "Renault Logan", "white", "z565vv", 23000, 230, 10, 4, "manual", CompanyCarType.ECONOMIC, RentType.HOURLY),
            new CompanyCar(4, "Daewoo Nexia", "black", "k113js", 18000, 190, 12, 4, "semi-automatic", CompanyCarType.BUSINESS, RentType.WEEKLY),
            new CompanyCar(5, "Toyota Camry", "orange", "b777kk", 55000, 280, 23, 5, "automatic", CompanyCarType.PRESTIGE, RentType.HOURLY),
            new CompanyCar(6, "Nissan GT-R", "blue", "k777so", 62000, 290, 25, 5, "semi-automatic", CompanyCarType.VIP, RentType.DAILY),
            new OwnerCar(7, "BMW 7-Series", "black", "o912pl", 30000, 180, 16, 4, "manual", 1, "182421sla32", 1113423),
            new OwnerCar(8, "Nissan XL", "purple", "j674ff", 32000, 210, 12, 5, "manual", 2, "833012sol12", 1114632),
            new OwnerCar(9, "Peugeot 308", "dark green", "o221ks", 17000, 160, 8, 5, "manual", 3, "927261apb22", 1114012)
    );
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Main method, includes switch case for user choice.
     */
    public static void main(String[] args) throws Exception {
        TaxiStation taxiStation = new TaxiStation(CARS);

        System.out.println("Enter a number to show: 1 for taxi station cars, 2 for taxi station cars total cost, " +
                "3 for cars, sorted by fuel consumption, 4 for cars with max speed more than entered.");
        int inputNumber = SCANNER.nextInt();

        switch (inputNumber) {
            case 1:
                printCars(taxiStation.getCars(), "Taxi Station cars: ");
                break;
            case 2:
                System.out.println("Taxi Station cost: " + TaxiStationService.getTotalCarsCost(taxiStation));
                break;
            case 3:
                printCars(TaxiStationService.sortByFuelConsumption(taxiStation),
                        "Cars, sorted by fuel consumption: ");
                break;
            case 4:
                printCars(TaxiStationService.sortByMaxSpeed(taxiStation), "Cars with entered max speed:");
                break;
            default:
                throw new Exception("number must be from 1 to 4!");
        }
    }

    /**
     * This method prints cars.
     *
     * @param cars    - cars list.
     * @param message - message for print.
     */
    private static void printCars(List<Car> cars, String message) {
        System.out.println(message);
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
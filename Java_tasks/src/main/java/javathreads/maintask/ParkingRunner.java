package javathreads.maintask;

import javathreads.maintask.entity.Car;
import javathreads.maintask.entity.Parking;
import javathreads.maintask.entity.ParkingPlace;

import java.util.ArrayList;
import java.util.List;

public class ParkingRunner {
    private static final int NUMBER_OF_CARS = 8;
    private static final int NUMBER_OF_PLACES = 3;

    public static void main(String[] args) {
        List<ParkingPlace> parkingPlaces = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PLACES; i++) {
            parkingPlaces.add(new ParkingPlace(i, null));
        }
        Parking parking = new Parking(parkingPlaces);
        for (int i = 1; i < NUMBER_OF_CARS + 1; i++) {
            new Thread(new Car(i, parking)).start();
        }
    }
}

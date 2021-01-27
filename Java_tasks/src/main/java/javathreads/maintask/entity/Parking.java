package javathreads.maintask.entity;

import java.util.List;

public class Parking {
    List<ParkingPlace> parkingPlaces;

    public Parking(List<ParkingPlace> parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    private boolean isFreePlace(ParkingPlace place) {
        return place.getCar() == null;
    }

    public synchronized ParkingPlace getParked(Car car) {
        for (ParkingPlace place : parkingPlaces) {
            if (isFreePlace(place)) {
                place.setCar(car);
                parkingPlaces.remove(place);
                return place;
            }
        }
        return null;
    }

    public synchronized void leftParking(ParkingPlace place) {
        place.setCar(null);
        parkingPlaces.add(place);
        notifyAll();
    }
}

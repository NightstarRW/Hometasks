package javathreads.maintask.entity;

public class Car implements Runnable {
    private int id;
    private Parking parking;

    public Car(int id, Parking parking) {
        this.id = id;
        this.parking = parking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        String car = "Car №"+ getId();
        ParkingPlace parkingPlace = null;
        try {
            System.out.println(car + " is trying to park");
            parkingPlace = parking.getParked(this);
            if (parkingPlace == null) {
                System.out.println(car + " is waiting for a free place");
                Thread.sleep(1200);
                parkingPlace = parking.getParked(this);
                if (parkingPlace == null) {
                    System.out.println(car + " is tired of waiting and left for another parking");
                    return;
                }
            }
            System.out.println(car + " is parked");
            parkingPlace.stayParked();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (parkingPlace != null) {
                System.out.println(car + " left the parking");
                parking.leftParking(parkingPlace);
            }
        }
    }
}

package javathreads.maintask.entity;

import java.util.Random;

public class ParkingPlace {
    private int id;
    private Car car;

    public ParkingPlace(int id, Car car) {
        this.id = id;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void stayParked() {
        try {
            Thread.sleep((new Random().nextInt(300) + 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

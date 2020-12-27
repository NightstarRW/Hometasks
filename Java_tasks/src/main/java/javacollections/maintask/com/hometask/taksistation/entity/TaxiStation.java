package javacollections.maintask.com.hometask.taksistation.entity;

import java.util.List;

/**
 * Taxi station entity class.
 *
 * @author Makism Sereda
 * @version 1.0 17.12.2020
 */
public class TaxiStation {
    private List<Car> cars;

    /**
     * Constructor for TaxiStation class.
     */
    public TaxiStation(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * This method gets cars list.
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * This method sets cars.
     *
     * @param cars - cars list.
     */
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("TaxiStation{");
        sb.append("cars=").append(cars);
        sb.append('}');
        return sb.toString();
    }
}

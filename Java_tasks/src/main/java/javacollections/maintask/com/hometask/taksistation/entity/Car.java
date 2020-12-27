package javacollections.maintask.com.hometask.taksistation.entity;

/**
 * Car entity class.
 *
 * @author Makism Sereda
 * @version 1.0 17.12.2020
 */
public abstract class Car {
    private int carId;
    private String model;
    private String color;
    private String number;
    private int price;
    private int maxSpeed;
    private int fuelConsumption;
    private int seatingCapacity;
    private String transmission;

    /**
     * Constructor for Car class.
     */
    public Car(int carId, String model, String color, String number, int price, int maxSpeed, int fuelConsumption,
               int seatingCapacity, String transmission) {
        this.carId = carId;
        this.model = model;
        this.color = color;
        this.number = number;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
        this.seatingCapacity = seatingCapacity;
        this.transmission = transmission;
    }

    /**
     * This method gets car model.
     */
    public String getModel() {
        return model;
    }

    /**
     * This method sets owned id.
     *
     * @param model - car model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * This method gets car color.
     */
    public String getColor() {
        return color;
    }

    /**
     * This method sets owned id.
     *
     * @param color - car color.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * This method gets car number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * This method sets owned id.
     *
     * @param number - car number.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * This method gets car price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * This method sets owned id.
     *
     * @param price - car price.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * This method gets owner id.
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * This method sets owned id.
     *
     * @param maxSpeed - car max speed.
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * This method gets car fuel consumption.
     */
    public int getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * This method sets owned id.
     *
     * @param fuelConsumption - car fuel consumption.
     */
    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * This method gets car seating capacity.
     */
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    /**
     * This method sets owned id.
     *
     * @param seatingCapacity - car seating capacity.
     */
    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    /**
     * This method gets car transmission.
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     * This method sets owned id.
     *
     * @param transmission - car transmission.
     */
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    /**
     * This method gets car id.
     */
    public int getCarId() {
        return carId;
    }

    /**
     * This method sets owned id.
     *
     * @param carId - car id.
     */
    public void setCarId(int carId) {
        this.carId = carId;
    }

}
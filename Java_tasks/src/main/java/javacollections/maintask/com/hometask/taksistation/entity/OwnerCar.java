package javacollections.maintask.com.hometask.taksistation.entity;

import java.util.Objects;

/**
 * Owner car entity class.
 *
 * @author Makism Sereda
 * @version 1.0 17.12.2020
 */
public class OwnerCar extends Car {
    private int ownerId;
    private String driverLicenseNumber;
    private int ownerInsuranceNumber;

    /**
     * Constructor with parameter's from OwnerCar and super class.
     */
    public OwnerCar(int carId, String model, String color, String number, int price, int maxSpeed,
                    int fuelConsumption, int seatingCapacity, String transmission, int ownerId,
                    String driverLicenseNumber, int ownerInsuranceNumber) {
        super(carId, model, color, number, price, maxSpeed, fuelConsumption, seatingCapacity, transmission);
        this.ownerId = ownerId;
        this.driverLicenseNumber = driverLicenseNumber;
        this.ownerInsuranceNumber = ownerInsuranceNumber;
    }

    /**
     * This method gets owner id.
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * This method sets owned id.
     *
     * @param ownerId - owner id.
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method gets owner id.
     */
    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    /**
     * This method sets owned id.
     *
     * @param driverLicenseNumber - driver license number.
     */
    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    /**
     * This method gets owner insurance number.
     */
    public int getOwnerInsuranceNumber() {
        return ownerInsuranceNumber;
    }

    /**
     * This method sets owned id.
     *
     * @param ownerInsuranceNumber - owner insurance number.
     */
    public void setOwnerInsuranceNumber(int ownerInsuranceNumber) {
        this.ownerInsuranceNumber = ownerInsuranceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OwnerCar ownerCar = (OwnerCar) o;
        return ownerId == ownerCar.ownerId &&
                ownerInsuranceNumber == ownerCar.ownerInsuranceNumber &&
                Objects.equals(driverLicenseNumber, ownerCar.driverLicenseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ownerId, driverLicenseNumber, ownerInsuranceNumber);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OwnerCar{");
        sb.append("carId=").append(getCarId());
        sb.append(", model='").append(getModel()).append('\'');
        sb.append(", color='").append(getColor()).append('\'');
        sb.append(", number='").append(getNumber()).append('\'');
        sb.append(", price=").append(getPrice());
        sb.append(", maxSpeed=").append(getMaxSpeed());
        sb.append(", fuelConsumption=").append(getFuelConsumption());
        sb.append(", seatingCapacity=").append(getSeatingCapacity());
        sb.append(", transmission='").append(getTransmission()).append('\'');
        sb.append(", ownerId=").append(ownerId);
        sb.append(", driverLicenseNumber='").append(driverLicenseNumber).append('\'');
        sb.append(", insuranceNumber=").append(ownerInsuranceNumber);
        sb.append('}');
        return sb.toString();
    }
}
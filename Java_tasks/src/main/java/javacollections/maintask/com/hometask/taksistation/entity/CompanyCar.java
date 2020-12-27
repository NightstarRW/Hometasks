package javacollections.maintask.com.hometask.taksistation.entity;

import javacollections.maintask.com.hometask.taksistation.types.CompanyCarType;
import javacollections.maintask.com.hometask.taksistation.types.RentType;

import java.util.Objects;

/**
 * Company car entity class.
 *
 * @author Makism Sereda
 * @version 1.0 17.12.2020
 */
public class CompanyCar extends Car {
    private CompanyCarType carClass;
    private RentType rentType;

    /**
     * Constructor with parameter's from CompanyCar and super class.
     */
    public CompanyCar(int carId, String model, String color, String number, int price, int maxSpeed,
                      int fuelConsumption, int seatingCapacity, String transmission, CompanyCarType carClass,
                      RentType rentType) {
        super(carId, model, color, number, price, maxSpeed, fuelConsumption, seatingCapacity, transmission);
        this.carClass = carClass;
        this.rentType = rentType;
    }

    /**
     * This method gets car class.
     */
    public CompanyCarType getCarClass() {
        return carClass;
    }

    /**
     * This method sets car class.
     *
     * @param carClass - car class.
     */
    public void setCarClass(CompanyCarType carClass) {
        this.carClass = carClass;
    }

    /**
     * This method gets car rent type.
     */
    public RentType getRentType() {
        return rentType;
    }

    /**
     * This method sets car rent type.
     *
     * @param rentType - car rent type.
     */
    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompanyCar that = (CompanyCar) o;
        return carClass == that.carClass &&
                rentType == that.rentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carClass, rentType);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CompanyCar{");
        sb.append("carId=").append(getCarId());
        sb.append(", model='").append(getModel()).append('\'');
        sb.append(", color='").append(getColor()).append('\'');
        sb.append(", number='").append(getNumber()).append('\'');
        sb.append(", price=").append(getPrice());
        sb.append(", maxSpeed=").append(getMaxSpeed());
        sb.append(", fuelConsumption=").append(getFuelConsumption());
        sb.append(", seatingCapacity=").append(getSeatingCapacity());
        sb.append(", transmission='").append(getTransmission()).append('\'');
        sb.append(", carClass=").append(carClass);
        sb.append(", rentType=").append(rentType);
        sb.append(", rentType=").append(getCarClass());
        sb.append('}');
        return sb.toString();
    }
}
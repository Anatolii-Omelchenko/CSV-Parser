package prog.academy.parser;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    @Save private int yearOfProd;
    @Save private String color;
    @Save private int maxSpeed;
    @Save private Driver driver;


    public Car() {
    }

    public Car(String brand, String model, int yearOfProd, String color, int maxSpeed, Driver driver) {
        this.brand = brand;
        this.model = model;
        this.yearOfProd = yearOfProd;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.driver = driver;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProd() {
        return yearOfProd;
    }

    public void setYearOfProd(int yearOfProd) {
        this.yearOfProd = yearOfProd;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return brand + " " + model + " " + yearOfProd +
                " | Color: " + color + " | Max speed: " +
                maxSpeed + "\n" + driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearOfProd == car.yearOfProd && maxSpeed == car.maxSpeed && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(driver, car.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, yearOfProd, color, maxSpeed, driver);
    }
}

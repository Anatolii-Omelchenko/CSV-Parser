package prog.academy.parser;

import java.util.Objects;

public class Driver {
    private String name;
    private int age;
    private int drivingExperience;

    public Driver() {
    }

    public Driver(String name, int age, int drivingExperience) {
        this.name = name;
        this.age = age;
        this.drivingExperience = drivingExperience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    @Override
    public String toString() {
        return "Driver: " + name + " | " + age + " years old | "
                + drivingExperience + " years of driving exp.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return age == driver.age && drivingExperience == driver.drivingExperience && Objects.equals(name, driver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, drivingExperience);
    }
}

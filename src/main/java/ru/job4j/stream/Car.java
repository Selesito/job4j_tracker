package ru.job4j.stream;

public class Car {
    private String brand;
    private String model;
    private String color;
    private int year;
    private int power;
    private int maxSpeed;
    private String stateNumber;

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", color='" + color + '\''
                + ", year=" + year
                + ", power=" + power
                + ", maxSpeed=" + maxSpeed
                + ", stateNumber='" + stateNumber + '\''
                +  '}';
    }

    static class Builder {
        private String brand;
        private String model;
        private String color;
        private int year;
        private int power;
        private int maxSpeed;
        private String stateNumber;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildYear(int year) {
            this.year = year;
            return this;
        }

        Builder buildPower(int power) {
            this.power = power;
            return this;
        }

        Builder buildMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder buildStateNumber(String stateNumber) {
            this.stateNumber = stateNumber;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.year = year;
            car.color = color;
            car.power = power;
            car.maxSpeed = maxSpeed;
            car.stateNumber = stateNumber;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder().buildBrand("BMW")
                .buildModel("3 series")
                .buildColor("Blue")
                .buildYear(2021)
                .buildPower(249)
                .buildMaxSpeed(258)
                .buildStateNumber("O020MO30RUS")
                .build();
        System.out.println(car);
    }

}

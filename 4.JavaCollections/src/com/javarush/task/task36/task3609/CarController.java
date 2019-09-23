package com.javarush.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }

    public void increaseSpeed(int seconds) {
        if (this.model.getSpeed() < this.model.getMaxSpeed()) {
            this.model.setSpeed((int)(this.model.getSpeed() + (3.5 * seconds)));
        }
        if (this.model.getSpeed() > this.model.getMaxSpeed()) {
            this.model.setSpeed(this.model.getMaxSpeed());
        }
    }

    public void decreaseSpeed(int seconds) {
        int speed = this.model.getSpeed();
        if (speed > 0) {
            this.model.setSpeed(speed - (12 * seconds));
        }
        if (speed < 0) {
            this.model.setSpeed(0);
        }
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }
}
package fr.bikemanager.dto;

import fr.bikemanager.entity.Motor;

import java.io.Serializable;

public class MotorDto implements Serializable {

    private int id;

    private float oilQuantity;

    private String brand;

    private int enginePower;

    private int engineCylinder;

    public MotorDto(Motor motor) {
        this.id = motor.getId();
        this.oilQuantity = motor.getOilQuantity();
        this.brand = motor.getBrand();
        this.enginePower = motor.getEnginePower();
        this.engineCylinder = motor.getEngineCylinder();
    }

    public float getOilQuantity() {
        return oilQuantity;
    }

    public void setOilQuantity(float oilQuantity) {
        this.oilQuantity = oilQuantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getEngineCylinder() {
        return engineCylinder;
    }

    public void setEngineCylinder(int engineCylinder) {
        this.engineCylinder = engineCylinder;
    }
}

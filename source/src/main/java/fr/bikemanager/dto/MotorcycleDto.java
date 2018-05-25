package fr.bikemanager.dto;

import fr.bikemanager.entity.Motorcycle;

import java.io.Serializable;

public class MotorcycleDto implements Serializable {

    private int id;

    private String brand;

    private String model;

    private int fiscalPower;

    public MotorcycleDto() {

    }

    public MotorcycleDto(Motorcycle motorcycle) {
        this.id = motorcycle.getId();
        this.brand = motorcycle.getBrand();
        this.model = motorcycle.getBrand();
        this.fiscalPower = motorcycle.getFiscalPower();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getFiscalPower() {
        return fiscalPower;
    }

    public void setFiscalPower(int fiscalPower) {
        this.fiscalPower = fiscalPower;
    }
}

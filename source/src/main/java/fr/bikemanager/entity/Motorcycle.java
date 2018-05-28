package fr.bikemanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "Motorcycle")
public class Motorcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String brand;

    private String model;

    @ManyToOne
    private Engine engine;

    private int fiscalPower;

    private String tireType;

    public Motorcycle() {

    }

    public Motorcycle(String brand, String model, Engine engine, int fiscalPower, String tireType) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.fiscalPower = fiscalPower;
        this.tireType = tireType;
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

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getFiscalPower() {
        return fiscalPower;
    }

    public void setFiscalPower(int fiscalPower) {
        this.fiscalPower = fiscalPower;
    }

    public String getTireType() {
        return tireType;
    }

    public void setTireType(String tireType) {
        this.tireType = tireType;
    }
}

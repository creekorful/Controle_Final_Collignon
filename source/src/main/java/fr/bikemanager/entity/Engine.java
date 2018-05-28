package fr.bikemanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "Engine")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private float oilQuantity;

    private String brand;

    private int enginePower;

    private int engineCylinder;

    public Engine() {

    }

    public Engine(float oilQuantity, String brand, int enginePower, int engineCylinder) {
        this.oilQuantity = oilQuantity;
        this.brand = brand;
        this.enginePower = enginePower;
        this.engineCylinder = engineCylinder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

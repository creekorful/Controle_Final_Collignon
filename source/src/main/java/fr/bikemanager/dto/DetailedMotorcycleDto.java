package fr.bikemanager.dto;

import fr.bikemanager.entity.Motorcycle;

public class DetailedMotorcycleDto extends MotorcycleDto {

    private EngineDto engine;

    private String tireType;

    private int fiscalPower;

    public DetailedMotorcycleDto() {

    }

    public DetailedMotorcycleDto(Motorcycle motorcycle) {
        super(motorcycle);
        this.engine = new EngineDto(motorcycle.getEngine());
        this.tireType = motorcycle.getTireType();
        this.fiscalPower = motorcycle.getFiscalPower();
    }

    public EngineDto getEngine() {
        return engine;
    }

    public void setEngine(EngineDto engine) {
        this.engine = engine;
    }

    public String getTireType() {
        return tireType;
    }

    public void setTireType(String tireType) {
        this.tireType = tireType;
    }

    public int getFiscalPower() {
        return fiscalPower;
    }

    public void setFiscalPower(int fiscalPower) {
        this.fiscalPower = fiscalPower;
    }
}

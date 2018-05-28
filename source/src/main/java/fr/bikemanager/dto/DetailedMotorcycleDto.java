package fr.bikemanager.dto;

import fr.bikemanager.entity.Motorcycle;

public class DetailedMotorcycleDto extends MotorcycleDto {

    private EngineDto engine;

    private String tireType;

    public DetailedMotorcycleDto() {

    }

    public DetailedMotorcycleDto(Motorcycle motorcycle) {
        super(motorcycle);
        this.engine = new EngineDto(motorcycle.getEngine());
        this.tireType = motorcycle.getTireType();
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
}

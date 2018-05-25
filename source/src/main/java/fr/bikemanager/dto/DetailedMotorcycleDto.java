package fr.bikemanager.dto;

import fr.bikemanager.entity.Motorcycle;

public class DetailedMotorcycleDto extends MotorcycleDto {

    private MotorDto motor;

    private String tireType;

    public DetailedMotorcycleDto() {

    }

    public DetailedMotorcycleDto(Motorcycle motorcycle) {
        super(motorcycle);
        this.motor = new MotorDto(motorcycle.getMotor());
        this.tireType = motorcycle.getTireType();
    }

    public MotorDto getMotor() {
        return motor;
    }

    public void setMotor(MotorDto motor) {
        this.motor = motor;
    }

    public String getTireType() {
        return tireType;
    }

    public void setTireType(String tireType) {
        this.tireType = tireType;
    }
}

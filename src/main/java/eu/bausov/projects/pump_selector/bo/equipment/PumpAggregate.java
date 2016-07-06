package eu.bausov.projects.pump_selector.bo.equipment;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PUMP_AGGREGATES")
@XmlRootElement
public class PumpAggregate extends Equipment {

    private String parameters;
    private Integer shaftSpeed;

    private Pump pump;
    private Seal seal;
    private Reducer reducer;
    private Motor motor;
    private DriverAssembly driverAssembly;
    private Frame frame;

    @Basic
    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    @Basic
    public Integer getShaftSpeed() {
        return shaftSpeed;
    }

    public void setShaftSpeed(Integer shaftSpeed) {
        this.shaftSpeed = shaftSpeed;
    }

    @ManyToOne(optional = false)
    public Pump getPump() {
        return pump;
    }

    public void setPump(Pump pump) {
        this.pump = pump;
    }

    @ManyToOne(optional = false)
    public Seal getSeal() {
        return seal;
    }

    public void setSeal(Seal seal) {
        this.seal = seal;
    }

    @ManyToOne(optional = false)
    public Reducer getReducer() {
        return reducer;
    }

    public void setReducer(Reducer reducer) {
        this.reducer = reducer;
    }

    @ManyToOne(optional = false)
    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @ManyToOne(optional = false)
    public DriverAssembly getDriverAssembly() {
        return driverAssembly;
    }

    public void setDriverAssembly(DriverAssembly driverAssembly) {
        this.driverAssembly = driverAssembly;
    }

    @ManyToOne(optional = false)
    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    @Transient
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(BigDecimal.ROUND_UNNECESSARY);
        totalPrice = totalPrice.add(pump.getPrice());
        totalPrice = totalPrice.add(reducer.getPrice());
        totalPrice = totalPrice.add(motor.getPrice());
        totalPrice = totalPrice.add(driverAssembly.getPrice());

        // Price * 2
        return totalPrice.multiply(new BigDecimal(2));
    }
}
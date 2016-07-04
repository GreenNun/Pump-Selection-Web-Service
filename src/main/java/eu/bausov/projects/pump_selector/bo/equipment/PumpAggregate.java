package eu.bausov.projects.pump_selector.bo.equipment;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PUMP_AGGREGATES")
@XmlRootElement
public class PumpAggregate extends Equipment {
    private String parameters;

    private Pump pump;
    private Seal seal;
    private ReliefValve reliefValve;
    private HeatingJacket heatingJacket;
    private Reducer reducer;
    private Motor motor;
    private Coupling coupling;
    private Frame frame;

    @Basic(optional = false)
    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
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
    public ReliefValve getReliefValve() {
        return reliefValve;
    }

    public void setReliefValve(ReliefValve reliefValve) {
        this.reliefValve = reliefValve;
    }

    @ManyToOne(optional = false)
    public HeatingJacket getHeatingJacket() {
        return heatingJacket;
    }

    public void setHeatingJacket(HeatingJacket heatingJacket) {
        this.heatingJacket = heatingJacket;
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
    public Coupling getCoupling() {
        return coupling;
    }

    public void setCoupling(Coupling coupling) {
        this.coupling = coupling;
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
        totalPrice = totalPrice.add(coupling.getPrice());
        totalPrice = totalPrice.add(frame.getPrice());

        // Price * 2
        return totalPrice.multiply(new BigDecimal(2));
    }
}
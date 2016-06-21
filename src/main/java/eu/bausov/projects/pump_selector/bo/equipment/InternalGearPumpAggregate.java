package eu.bausov.projects.pump_selector.bo.equipment;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PUMP_AGGREGATES")
public class InternalGearPumpAggregate extends Equipment {
    private InternalGearPump internalGearPump;
    private Reducer reducer;
    private Motor motor;
    private Coupling coupling;
    private Frame frame;
    private Integer speedOnShaft;

    @ManyToOne(optional = false)
    public InternalGearPump getInternalGearPump() {
        return internalGearPump;
    }

    public void setInternalGearPump(InternalGearPump internalGearPump) {
        this.internalGearPump = internalGearPump;
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

    @Basic(optional = false)
    public Integer getSpeedOnShaft() {
        return speedOnShaft;
    }

    public void setSpeedOnShaft(Integer speedOnShaft) {
        this.speedOnShaft = speedOnShaft;
    }

    @Basic(optional = false)
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(BigDecimal.ROUND_UNNECESSARY);
        totalPrice = totalPrice.add(internalGearPump.getPrice());
        totalPrice = totalPrice.add(reducer.getPrice());
        totalPrice = totalPrice.add(motor.getPrice());
        totalPrice = totalPrice.add(coupling.getPrice());
        totalPrice = totalPrice.add(frame.getPrice());

        return totalPrice;
    }
}

package eu.bausov.projects.srvpumpselection.bo.equipment;

import eu.bausov.projects.srvpumpselection.bo.JPA;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PUMP_AGGREGATES")
@XmlRootElement
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PumpAggregate extends JPA {

    private String parameters;
    private Integer shaftSpeed;
    private BigDecimal price;

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

    @Basic(optional = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
    @XmlTransient
    public void setTotalPrice(double coefficient) {
        BigDecimal totalPrice = new BigDecimal(BigDecimal.ROUND_UNNECESSARY);
        totalPrice = totalPrice.add(pump.getPrice());
        totalPrice = totalPrice.add(reducer.getPrice());
        totalPrice = totalPrice.add(motor.getPrice());
        totalPrice = totalPrice.add(driverAssembly.getPrice());
        totalPrice = totalPrice.add(frame.getPrice());

        // Example, Price * 2
        this.setPrice(totalPrice.multiply(new BigDecimal(coefficient)));
    }
}
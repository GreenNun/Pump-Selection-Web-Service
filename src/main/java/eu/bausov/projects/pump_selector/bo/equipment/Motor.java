package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Producer;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_MOTORS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer", "vendor"})})
public class Motor extends Equipment {
    private Producer vendor;
    private Constant constSpeed;
    private Constant constExplosionProof;
    private Constant constPowerHp;

    public Motor() {
    }

    public Motor(Producer producer, String modelName, BigDecimal price, Producer vendor, Constant constSpeed,
                 Constant constExplosionProof, Constant constPowerHp) {
        this.setProducer(producer);
        this.setModelName(modelName);
        this.setPrice(price);
        this.vendor = vendor;
        this.constSpeed = constSpeed;
        this.constExplosionProof = constExplosionProof;
        this.constPowerHp = constPowerHp;
    }

    @ManyToOne(optional = false)
    public Producer getVendor() {
        return vendor;
    }

    public void setVendor(Producer vendor) {
        this.vendor = vendor;
    }

    @ManyToOne(optional = false)
    public Constant getConstSpeed() {
        return constSpeed;
    }

    public void setConstSpeed(Constant constSpeed) {
        this.constSpeed = constSpeed;
    }

    @ManyToOne(optional = false)
    public Constant getConstExplosionProof() {
        return constExplosionProof;
    }

    public void setConstExplosionProof(Constant constExplosionProof) {
        this.constExplosionProof = constExplosionProof;
    }

    @ManyToOne(optional = false)
    public Constant getConstPowerHp() {
        return constPowerHp;
    }

    public void setConstPowerHp(Constant constPowerHp) {
        this.constPowerHp = constPowerHp;
    }

    public boolean isMotorValid(Reducer reducer) {
        return constPowerHp.getIntegerValue() == reducer.getConstRequiredMotorPowerHp().getIntegerValue();
    }

    @Transient
    public boolean isExplosionProofAvailable(){
        return !getConstExplosionProof().getValue().equals("none");
    }
}
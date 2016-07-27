package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Producer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_MOTORS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer", "vendor",
        "const_Speed", "const_Explosion_Proof", "const_Power_Hp", "const_Motor_Frame_Size"})})
@XmlRootElement
public class Motor extends Equipment {
    private Producer vendor;
    private Constant constSpeed;
    private Constant constExplosionProof;
    private Constant constPowerHp;
    private Constant constMotorFrameSize;

    public Motor() {
    }

    public Motor(Producer producer, String modelName, BigDecimal price, Producer vendor, Constant constSpeed,
                 Constant constExplosionProof, Constant constPowerHp, Constant constMotorFrameSize) {
        this.setProducer(producer);
        this.setModelName(modelName);
        this.setPrice(price);
        this.vendor = vendor;
        this.constSpeed = constSpeed;
        this.constExplosionProof = constExplosionProof;
        this.constPowerHp = constPowerHp;
        this.constMotorFrameSize = constMotorFrameSize;
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

    @ManyToOne(optional = false)
    public Constant getConstMotorFrameSize() {
        return constMotorFrameSize;
    }

    public void setConstMotorFrameSize(Constant constMotorFrameSize) {
        this.constMotorFrameSize = constMotorFrameSize;
    }

    // TODO: 14.07.2016
    public boolean isMotorValid(Reducer reducer) {
        return constPowerHp.getDoubleValue() == reducer.getConstRequiredMotorPowerHp().getDoubleValue() &&
                getConstMotorFrameSize().getValue().equals(reducer.getConstMotorFrameSize().getValue());
    }

    @Transient
    public boolean isExplosionProofAvailable(){
        return !getConstExplosionProof().getValue().equals("none");
    }
}
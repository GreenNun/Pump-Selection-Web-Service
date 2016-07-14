package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Producer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Reducer (Geared Box).
 * <p>
 * Constants:
 * <p>
 * constExplosionProof            name:   "explosion proof";
 * value:  "none" | "ATEX";
 * <p>
 * constRequiredMotorPowerHp      name:   "required motor power [HP]";
 * value:  "5" | "7.5" | "10" | "15" | "20";
 */
@Entity
@Table(name = "TB_REDUCERS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer", "vendor",
        "minRpm", "maxRpm", "const_Explosion_Proof", "const_Required_Motor_Power_Hp"})})
@XmlRootElement
public class Reducer extends Equipment {
    private Producer vendor;
    private Integer minRpm;
    private Integer maxRpm;
    private Constant constExplosionProof;
    private Constant constRequiredMotorPowerHp;
    private Constant constMotorFrameSize;

    public Reducer() {
    }

    public Reducer(Producer producer, String modelName, BigDecimal price, Producer vendor, Integer minRpm,
                   Integer maxRpm, Constant constExplosionProof, Constant constRequiredMotorPowerHp,
                   Constant constMotorFrameSize) {
        this.setProducer(producer);
        this.setModelName(modelName);
        this.setPrice(price);
        this.vendor = vendor;
        this.minRpm = minRpm;
        this.maxRpm = maxRpm;
        this.constExplosionProof = constExplosionProof;
        this.constRequiredMotorPowerHp = constRequiredMotorPowerHp;
        this.constMotorFrameSize = constMotorFrameSize;
    }

    @ManyToOne(optional = false)
    public Producer getVendor() {
        return vendor;
    }

    public void setVendor(Producer vendor) {
        this.vendor = vendor;
    }

    @Basic(optional = false)
    public Integer getMinRpm() {
        return minRpm;
    }

    public void setMinRpm(Integer minRpm) {
        this.minRpm = minRpm;
    }

    @Basic(optional = false)
    public Integer getMaxRpm() {
        return maxRpm;
    }

    public void setMaxRpm(Integer maxRpm) {
        this.maxRpm = maxRpm;
    }

    @ManyToOne
    public Constant getConstExplosionProof() {
        return constExplosionProof;
    }

    public void setConstExplosionProof(Constant constExplosionProof) {
        this.constExplosionProof = constExplosionProof;
    }

    @ManyToOne(optional = false)
    public Constant getConstRequiredMotorPowerHp() {
        return constRequiredMotorPowerHp;
    }

    public void setConstRequiredMotorPowerHp(Constant constRequiredMotorPowerHp) {
        this.constRequiredMotorPowerHp = constRequiredMotorPowerHp;
    }

    @ManyToOne(optional = false)
    public Constant getConstMotorFrameSize() {
        return constMotorFrameSize;
    }

    public void setConstMotorFrameSize(Constant constMotorFrameSize) {
        this.constMotorFrameSize = constMotorFrameSize;
    }
}

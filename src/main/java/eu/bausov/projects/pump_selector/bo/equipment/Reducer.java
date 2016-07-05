package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Producer;
import eu.bausov.projects.pump_selector.bo.Range;

import javax.persistence.*;
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
@Table(name = "TB_REDUCERS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer", "vendor"})})
public class Reducer extends Equipment {
    private Producer vendor;
    private Range speedRange;
    private Constant constExplosionProof;
    private Constant constRequiredMotorPowerHp;

    public Reducer() {
    }

    public Reducer(Producer producer, String modelName, BigDecimal price, Producer vendor, Range speedRange,
                   Constant constExplosionProof, Constant constRequiredMotorPowerHp) {
        this.setProducer(producer);
        this.setModelName(modelName);
        this.setPrice(price);
        this.vendor = vendor;
        this.speedRange = speedRange;
        this.constExplosionProof = constExplosionProof;
        this.constRequiredMotorPowerHp = constRequiredMotorPowerHp;
    }

    @ManyToOne(optional = false)
    public Producer getVendor() {
        return vendor;
    }

    public void setVendor(Producer vendor) {
        this.vendor = vendor;
    }

    @ManyToOne(optional = false)
    public Range getSpeedRange() {
        return speedRange;
    }

    public void setSpeedRange(Range speedRange) {
        this.speedRange = speedRange;
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
}

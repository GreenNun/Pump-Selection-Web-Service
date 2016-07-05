package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Producer;
import eu.bausov.projects.pump_selector.bo.Range;

import javax.persistence.*;

/**
 * Reducer (Geared Box).
 */
@Entity
@Table(name = "TB_REDUCERS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer", "vendor"})})
public class Reducer extends Equipment {
    private Producer vendor;
    private Range speedRange;
    private Constant constExplosionProof;
    private Constant constRequiredMotorPowerHp;

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

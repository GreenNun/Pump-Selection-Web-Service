package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Range;

import javax.persistence.*;

/**
 * Reducer (Geared Box).
 */
@Entity
@Table(name = "TB_REDUCERS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class Reducer extends Equipment {
    private Range speedRange;
    private Constant explosionProof;
    private Constant requiredMotorPowerHp;

    @ManyToOne(optional = false)
    public Range getSpeedRange() {
        return speedRange;
    }

    public void setSpeedRange(Range speedRange) {
        this.speedRange = speedRange;
    }

    @ManyToOne
    public Constant getExplosionProof() {
        return explosionProof;
    }

    public void setExplosionProof(Constant explosionProof) {
        this.explosionProof = explosionProof;
    }

    @ManyToOne(optional = false)
    public Constant getSuitablePowerHp() {
        return requiredMotorPowerHp;
    }

    public void setSuitablePowerHp(Constant requieredMotorPowerHp) {
        this.requiredMotorPowerHp = requieredMotorPowerHp;
    }
}

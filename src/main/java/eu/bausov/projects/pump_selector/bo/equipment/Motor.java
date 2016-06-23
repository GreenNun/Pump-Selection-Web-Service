package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.*;

@Entity
@Table(name = "TB_MOTORS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class Motor extends Equipment {
    private Constant constSpeed;
    private Constant constExplosionProof;
    private Constant constPowerHp;

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

    public boolean isExplosionProofAvailable(){
        return !getConstExplosionProof().getValue().equals("none");
    }
}

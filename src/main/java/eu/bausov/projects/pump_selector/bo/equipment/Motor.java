package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.*;

@Entity
@Table(name = "TB_MOTORS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class Motor extends Equipment {

    private Constant speed;
    private Constant explosionProof;
    private Constant powerHp;

    @ManyToOne(optional = false)
    public Constant getSpeed() {
        return speed;
    }

    public void setSpeed(Constant speed) {
        this.speed = speed;
    }

    @ManyToOne(optional = false)
    public Constant getExplosionProof() {
        return explosionProof;
    }

    public void setExplosionProof(Constant explosionProof) {
        this.explosionProof = explosionProof;
    }

    @ManyToOne(optional = false)
    public Constant getPowerHp() {
        return powerHp;
    }

    public void setPowerHp(Constant powerHp) {
        this.powerHp = powerHp;
    }
}

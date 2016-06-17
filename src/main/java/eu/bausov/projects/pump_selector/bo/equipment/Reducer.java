package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.*;

@Entity
@Table(name = "TB_REDUCERS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class Reducer extends Equipment {
    private Integer speedRangeFrom;
    private Integer speedRangeTo;
    private Constant explosionProof;

    @Basic(optional = false)
    public Integer getSpeedRangeFrom() {
        return speedRangeFrom;
    }

    public void setSpeedRangeFrom(Integer speedRangeFrom) {
        this.speedRangeFrom = speedRangeFrom;
    }

    @Basic(optional = false)
    public Integer getSpeedRangeTo() {
        return speedRangeTo;
    }

    public void setSpeedRangeTo(Integer speedRangeTo) {
        this.speedRangeTo = speedRangeTo;
    }

    @ManyToOne(optional = false)
    public Constant getExplosionProof() {
        return explosionProof;
    }

    public void setExplosionProof(Constant explosionProof) {
        this.explosionProof = explosionProof;
    }
}

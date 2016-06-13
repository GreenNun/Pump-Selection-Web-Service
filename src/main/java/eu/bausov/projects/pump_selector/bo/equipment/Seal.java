package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_SEALS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class Seal extends Equipment {
    private Constant sealType;

    @ManyToOne(optional = false)
    public Constant getSealType() {
        return sealType;
    }

    public void setSealType(Constant sealType) {
        this.sealType = sealType;
    }
}

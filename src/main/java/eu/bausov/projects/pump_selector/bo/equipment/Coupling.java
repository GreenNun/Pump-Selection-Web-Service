package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TB_COUPLINGS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer", "couplingType", "suitablePump"})})
public class Coupling extends Equipment {
    private Constant couplingType;
    private Pump suitablePump;

    @ManyToOne(optional = false)
    public Constant getCouplingType() {
        return couplingType;
    }

    public void setCouplingType(Constant couplingType) {
        this.couplingType = couplingType;
    }

    @ManyToOne(optional = false)
    public Pump getSuitablePump() {
        return suitablePump;
    }

    public void setSuitablePump(Pump suitablePump) {
        this.suitablePump = suitablePump;
    }
}

package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Set;

@Entity
@Table(name = "TB_COUPLINGS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class Coupling extends Equipment {
    private Constant couplingType;
    // TODO: 23.06.2016 mapping
    private Set<Pump> suitablePumps;

    @ManyToOne(optional = false)
    public Constant getCouplingType() {
        return couplingType;
    }

    public void setCouplingType(Constant couplingType) {
        this.couplingType = couplingType;
    }

    public Set<Pump> getSuitablePumps() {
        return suitablePumps;
    }

    public void setSuitablePumps(Set<Pump> suitablePumps) {
        this.suitablePumps = suitablePumps;
    }
}

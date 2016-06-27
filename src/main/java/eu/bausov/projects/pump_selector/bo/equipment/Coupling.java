package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TB_COUPLINGS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class Coupling extends Equipment {
    private Constant couplingType;
    private Set<Pump> suitablePumps;

    @ManyToOne(optional = false)
    public Constant getCouplingType() {
        return couplingType;
    }

    public void setCouplingType(Constant couplingType) {
        this.couplingType = couplingType;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Pump> getSuitablePumps() {
        return suitablePumps;
    }

    public void setSuitablePumps(Set<Pump> suitablePumps) {
        this.suitablePumps = suitablePumps;
    }
}

package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Set;

@Entity
@Table(name = "TB_RELIEF_VALVES", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class ReliefValve extends Equipment {
    // TODO: 23.06.2016 mapping
    private Set<Pump> suitablePumps;

    public Set<Pump> getSuitablePumps() {
        return suitablePumps;
    }

    public void setSuitablePumps(Set<Pump> suitablePumps) {
        this.suitablePumps = suitablePumps;
    }
}

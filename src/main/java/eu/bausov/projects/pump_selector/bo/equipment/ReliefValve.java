package eu.bausov.projects.pump_selector.bo.equipment;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TB_RELIEF_VALVES", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class ReliefValve extends Equipment {
    private Set<Pump> suitablePumps;

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Pump> getSuitablePumps() {
        return suitablePumps;
    }

    public void setSuitablePumps(Set<Pump> suitablePumps) {
        this.suitablePumps = suitablePumps;
    }
}

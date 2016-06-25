package eu.bausov.projects.pump_selector.bo.equipment;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Set;

@Entity
@Table(name = "TB_FRAMES", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class Frame extends Equipment {
    // TODO: 23.06.2016 mapping
    private Set<Pump> suitablePumps;

    public Set<Pump> getSuitablePumps() {
        return suitablePumps;
    }

    public void setSuitablePumps(Set<Pump> suitablePumps) {
        this.suitablePumps = suitablePumps;
    }
}
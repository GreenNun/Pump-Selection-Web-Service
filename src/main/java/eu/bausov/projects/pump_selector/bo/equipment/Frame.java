package eu.bausov.projects.pump_selector.bo.equipment;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TB_FRAMES", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class Frame extends Equipment {
    private Set<Pump> suitablePumps;

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Pump> getSuitablePumps() {
        return suitablePumps;
    }

    public void setSuitablePumps(Set<Pump> suitablePumps) {
        this.suitablePumps = suitablePumps;
    }
}
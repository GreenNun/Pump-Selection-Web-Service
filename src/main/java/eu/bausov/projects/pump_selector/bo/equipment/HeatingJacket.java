package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TB_HEATING_JACKETS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class HeatingJacket extends Equipment {
    private Constant heatingJacketType;
    private Set<Pump> suitablePumps;

    @ManyToOne(optional = false)
    public Constant getHeatingJacketType() {
        return heatingJacketType;
    }

    public void setHeatingJacketType(Constant heatingJacketType) {
        this.heatingJacketType = heatingJacketType;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Pump> getSuitablePumps() {
        return suitablePumps;
    }

    public void setSuitablePumps(Set<Pump> suitablePumps) {
        this.suitablePumps = suitablePumps;
    }
}

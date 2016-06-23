package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Set;

@Entity
@Table(name = "TB_HEATING_JACKETS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class HeatingJacket {
    private Constant heatingJacketType;
    // TODO: 23.06.2016 mapping
    private Set<Pump> suitablePumps;

    @ManyToOne(optional = false)
    public Constant getHeatingJacketType() {
        return heatingJacketType;
    }

    public void setHeatingJacketType(Constant heatingJacketType) {
        this.heatingJacketType = heatingJacketType;
    }

    public Set<Pump> getSuitablePumps() {
        return suitablePumps;
    }

    public void setSuitablePumps(Set<Pump> suitablePumps) {
        this.suitablePumps = suitablePumps;
    }
}

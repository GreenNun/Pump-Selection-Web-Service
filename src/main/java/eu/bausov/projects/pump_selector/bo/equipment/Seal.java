package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Set;

@Entity
@Table(name = "TB_SEALS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class Seal extends Equipment {
    private Constant sealType;
    // TODO: 23.06.2016 mapping
    private Set<Pump> suitablePumps;

    @ManyToOne(optional = false)
    public Constant getSealType() {
        return sealType;
    }

    public void setSealType(Constant sealType) {
        this.sealType = sealType;
    }

    public Set<Pump> getSuitablePumps() {
        return suitablePumps;
    }

    public void setSuitablePumps(Set<Pump> suitablePumps) {
        this.suitablePumps = suitablePumps;
    }

    // if producer, country and model name are equal/
    public boolean isSealValid(Pump pump) {
        if (pump == null) return false;
        for (Pump pumpFromSet : suitablePumps) {
            if (pump.getProducer().getProducerName().equals(pumpFromSet.getProducer().getProducerName()) &&
                    pump.getProducer().getProducerCountry().equals(pumpFromSet.getProducer().getProducerCountry()) &&
                    pump.getModelName().equals(pumpFromSet.getModelName())) return true;
        }
        return false;
    }
}

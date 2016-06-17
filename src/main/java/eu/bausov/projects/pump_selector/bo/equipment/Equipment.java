package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.JPA;
import eu.bausov.projects.pump_selector.bo.Producer;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Equipment extends JPA {

    private Producer producer;
    private String modelName;
    private BigDecimal price;

    @ManyToOne(optional = false)
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @Basic(optional = false)
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Basic(optional = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

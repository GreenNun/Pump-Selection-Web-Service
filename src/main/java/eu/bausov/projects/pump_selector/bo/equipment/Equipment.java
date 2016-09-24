package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.JPA;
import eu.bausov.projects.pump_selector.bo.Producer;

import javax.persistence.Basic;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;

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

    @XmlTransient // comment to show price
    @Basic(optional = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment)) return false;

        Equipment equipment = (Equipment) o;

        if (!producer.equals(equipment.producer)) return false;
        if (!modelName.equals(equipment.modelName)) return false;
        return price != null ? price.equals(equipment.price) : equipment.price == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + producer.hashCode();
        result = 31 * result + modelName.hashCode();
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}

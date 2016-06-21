package eu.bausov.projects.pump_selector.bo;

import javax.persistence.*;

@Entity
@Table(name = "TB_PRODUCERS", uniqueConstraints = {@UniqueConstraint(columnNames = {"producerName", "producer_country"})})
public class Producer extends JPA {

    private String producerName;
    private Constant producerCountry;

    @Basic(optional = false)
    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    @ManyToOne(optional = false)
    public Constant getProducerCountry() {
        return producerCountry;
    }

    public void setProducerCountry(Constant producerCountry) {
        this.producerCountry = producerCountry;
    }
}

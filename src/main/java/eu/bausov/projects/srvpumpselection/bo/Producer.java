package eu.bausov.projects.srvpumpselection.bo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TB_PRODUCERS", uniqueConstraints = {@UniqueConstraint(columnNames = {"producer_name", "producer_country"})})
@XmlRootElement
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Producer extends JPA {

    private String producerName;
    private Constant producerCountry;

    public Producer() {
    }

    public Producer(String producerName, Constant producerCountry) {
        this.producerName = producerName;
        this.producerCountry = producerCountry;
    }

    @Basic(optional = false)
    @Column(name = "producer_name")
    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "producer_country")
    public Constant getProducerCountry() {
        return producerCountry;
    }

    public void setProducerCountry(Constant producerCountry) {
        this.producerCountry = producerCountry;
    }

    @Override
    @Transient
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producer)) return false;

        Producer producer = (Producer) o;

        if (!producerName.equals(producer.producerName)) return false;
        return producerCountry.equals(producer.producerCountry);

    }

    @Override
    @Transient
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + producerName.hashCode();
        result = 31 * result + producerCountry.hashCode();
        return result;
    }
}

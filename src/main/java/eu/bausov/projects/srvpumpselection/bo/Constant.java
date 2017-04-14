package eu.bausov.projects.srvpumpselection.bo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "TB_CONSTANTS", uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "value" }) })
@XmlRootElement
public class Constant extends JPA {
    private String name;
    private String value;

    public Constant() {
    }

    public Constant(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Basic(optional = false)
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String label) {
        this.name = label;
    }

    @Basic(optional = false)
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Parses string value of Constant to integer type.
     *
     * @return int value
     */
    @Transient
    @XmlTransient
    public int getIntegerValue(){
        return Integer.parseInt(value);
    }

    /**
     * Parses string value of Constant to double type.
     *
     * @return double value
     */
    @Transient
    @XmlTransient
    public double getDoubleValue(){
        return Double.parseDouble(value);
    }
}
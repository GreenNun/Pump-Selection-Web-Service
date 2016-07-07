package eu.bausov.projects.pump_selector.bo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

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
    public String getName() {
        return name;
    }

    public void setName(String label) {
        this.name = label;
    }

    @Basic(optional = false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Constant)) return false;

        Constant constant = (Constant) o;

        if (!name.equals(constant.name)) return false;
        return value.equals(constant.value);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    /**
     * Parses string value of Constant to integer type.
     *
     * @return int value
     */
    @Transient
    public int getIntegerValue(){
        return Integer.parseInt(value);
    }

    /**
     * Parses string value of Constant to double type.
     *
     * @return double value
     */
    @Transient
    public double getDoubleValue(){
        return Double.parseDouble(value);
    }
}
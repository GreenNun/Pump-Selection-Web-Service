package eu.bausov.projects.pump_selector.bo;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_CONSTANTS", uniqueConstraints = { @UniqueConstraint(columnNames = { "key", "value" }) })
public class Constant extends JPA {

    private String key;
    private String value;

    @Basic(optional = false)
    public String getKey() {
        return key;
    }

    public void setKey(String label) {
        this.key = label;
    }

    @Basic(optional = false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

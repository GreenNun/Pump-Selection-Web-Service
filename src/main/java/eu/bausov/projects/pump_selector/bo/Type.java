package eu.bausov.projects.pump_selector.bo;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_TYPES", uniqueConstraints = { @UniqueConstraint(columnNames = { "label", "type" }) })
public class Type extends JPA {

    private String label;
    private String type;

    @Basic(optional = false)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic(optional = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package eu.bausov.projects.pump_selector.bo;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SPEED_CORRECTION_COEFFICIENTS")
public class SpeedCorrectionCoefficient extends JPA implements Comparable<SpeedCorrectionCoefficient> {
    private Integer viscosity;
    private Integer coefficient;

    @Basic(optional = false)
    public Integer getViscosity() {
        return viscosity;
    }

    public void setViscosity(Integer viscosity) {
        this.viscosity = viscosity;
    }

    @Basic(optional = false)
    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    @Override // for sorting in Stream API
    public int compareTo(SpeedCorrectionCoefficient c) {
        return Integer.compare(viscosity, c.viscosity);
    }
}

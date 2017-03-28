package eu.bausov.projects.srvpumpselection.bo;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TB_SPEED_CORRECTION_COEFFICIENTS")
@XmlRootElement
public class SpeedCorrectionCoefficient extends JPA implements Comparable<SpeedCorrectionCoefficient> {
    private Integer viscosity;
    private Integer coefficient;

    public SpeedCorrectionCoefficient() {
    }

    public SpeedCorrectionCoefficient(Integer viscosity, Integer coefficient) {
        this.viscosity = viscosity;
        this.coefficient = coefficient;
    }

    @Basic(optional = false)
    @Column(name = "viscosity")
    public Integer getViscosity() {
        return viscosity;
    }

    public void setViscosity(Integer viscosity) {
        this.viscosity = viscosity;
    }

    @Basic(optional = false)
    @Column(name = "coefficient")
    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    @Override // for sorting in Stream API
    public int compareTo(@NotNull SpeedCorrectionCoefficient c) {
        return Integer.compare(viscosity, c.viscosity);
    }
}
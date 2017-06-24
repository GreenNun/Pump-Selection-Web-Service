package eu.bausov.projects.srvpumpselection.bo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TB_SPEED_CORRECTION_COEFFICIENTS")
@XmlRootElement
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
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
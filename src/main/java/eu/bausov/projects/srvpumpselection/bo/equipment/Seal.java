package eu.bausov.projects.srvpumpselection.bo.equipment;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.bo.Producer;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Seal.
 * <p>
 * Constants;
 * <p>
 * sealType              name:   "seal type";
 * value:  "Packing" | "Rotatherm Seal" | "Mechanical Seal" | "Lip Seal" | "Cartridge Mechanical Seal";
 * <p>
 * oRingMaterial         name:   "material";
 * value:  "none" | "Viton&reg;";
 */
@Entity
@Table(name = "TB_SEALS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer", "seal_Type",
        "oRing_Material"})})
@XmlRootElement
public class Seal extends Equipment implements SuitablePumps {
    private Constant sealType;
    private Constant oRingMaterial;
    private Set<Pump> suitablePumps;

    public Seal() {
    }

    public Seal(Producer producer, String modelName, BigDecimal price, Constant sealType, Constant oRingMaterial,
                Set<Pump> suitablePumps) {
        this.setProducer(producer);
        this.setModelName(modelName);
        this.setPrice(price);
        this.sealType = sealType;
        this.oRingMaterial = oRingMaterial;
        this.suitablePumps = suitablePumps;
    }

    @ManyToOne(optional = false)
    public Constant getSealType() {
        return sealType;
    }

    public void setSealType(Constant sealType) {
        this.sealType = sealType;
    }

    @ManyToOne
    public Constant getORingMaterial() {
        return oRingMaterial;
    }

    public void setORingMaterial(Constant oRingMaterial) {
        this.oRingMaterial = oRingMaterial;
    }

    @XmlTransient
    @Fetch(FetchMode.SUBSELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Pump> getSuitablePumps() {
        return suitablePumps;
    }

    public void setSuitablePumps(Set<Pump> suitablePumps) {
        this.suitablePumps = suitablePumps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Seal seal = (Seal) o;

        if (!sealType.equals(seal.sealType)) return false;
        return oRingMaterial != null ? oRingMaterial.equals(seal.oRingMaterial) : seal.oRingMaterial == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + sealType.hashCode();
        result = 31 * result + (oRingMaterial != null ? oRingMaterial.hashCode() : 0);
        return result;
    }
}
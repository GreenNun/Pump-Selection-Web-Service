package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Producer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Seal.
 * <p>
 * Constants;
 * <p>
 * sealType              name:   "seal type";
 * value:  "Packing" | "Rotatherm Seal" | "Mechanical seal" | "Lip Seal" | "Cartex Mechanical Seal";
 * <p>
 * oRingMaterial         name:   "o-ring material";
 * value:  "none" | "Viton&reg;";
 */
@Entity
@Table(name = "TB_SEALS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer", "seal_Type",
        "oRing_Material"})})
public class Seal extends Equipment {
    private Constant sealType;
    private Constant oRingMaterial;
    private Set<Pump> suitablePumps;

    public Seal() {
    }

    public Seal(Producer producer, String modelName, BigDecimal price, Constant sealType, Constant oRingMaterial) {
        this.setProducer(producer);
        this.setModelName(modelName);
        this.setPrice(price);
        this.sealType = sealType;
        this.oRingMaterial = oRingMaterial;
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
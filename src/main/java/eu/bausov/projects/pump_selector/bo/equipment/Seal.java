package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TB_SEALS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer", "sealType", "oRingMaterial"})})
public class Seal extends Equipment {
    private Constant sealType;
    private Constant oRingMaterial;

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

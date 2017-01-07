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
 * Driver assembling entity.
 * <p>
 * modelName as relative pumps model name.
 * <p>
 * Constants:
 * <p>
 * driverAssemblyType       name:   "driver assembly type";
 * value:  "Pump Adder" | "Coupling" | "Flexible Coupling" | "Belt and Pulley" | "Ex.Proof Coupling";
 * <p>
 * constExplosionProof      name:   "explosion proof";
 * value:  "none" | "ATEX";
 */
@Entity
@Table(name = "TB_DRIVER_ASSEMBLIES", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer",
        "driver_Assembly_Type", "const_Explosion_Proof"})})
@XmlRootElement
public class DriverAssembly extends Equipment implements SuitablePumps {
    private Constant driverAssemblyType;
    private Constant constExplosionProof;
    private Set<Pump> suitablePumps;

    public DriverAssembly() {
    }

    public DriverAssembly(Producer producer, String modelName, BigDecimal price, Constant driverAssemblyType,
                          Constant constExplosionProof, Set<Pump> suitablePumps) {
        this.setProducer(producer);
        this.setModelName(modelName);
        this.setPrice(price);
        this.driverAssemblyType = driverAssemblyType;
        this.constExplosionProof = constExplosionProof;
        this.suitablePumps = suitablePumps;
    }

    @ManyToOne(optional = false)
    public Constant getDriverAssemblyType() {
        return driverAssemblyType;
    }

    public void setDriverAssemblyType(Constant driverAssemblyType) {
        this.driverAssemblyType = driverAssemblyType;
    }

    @ManyToOne(optional = false)
    public Constant getConstExplosionProof() {
        return constExplosionProof;
    }

    public void setConstExplosionProof(Constant constExplosionProof) {
        this.constExplosionProof = constExplosionProof;
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

        DriverAssembly that = (DriverAssembly) o;

        if (!driverAssemblyType.equals(that.driverAssemblyType)) return false;
        return constExplosionProof.equals(that.constExplosionProof);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + driverAssemblyType.hashCode();
        result = 31 * result + constExplosionProof.hashCode();
        return result;
    }
}

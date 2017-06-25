package eu.bausov.projects.srvpumpselection.bo.equipment;

import eu.bausov.projects.srvpumpselection.bo.Constant;
import eu.bausov.projects.srvpumpselection.bo.Producer;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Drive assembling entity.
 * <p>
 * modelName as relative pumps model name.
 * <p>
 * Constants:
 * <p>
 * constDriveAssemblyType       name:   "drive assembly type";
 * value:  "Pump Adder" | "Coupling" | "Flexible Coupling" | "Belt and Pulley" | "Ex.Proof Coupling";
 * <p>
 * constExplosionProof      name:   "explosion proof";
 * value:  "none" | "ATEX";
 */
@Entity
@Table(name = "TB_DRIVE_ASSEMBLIES", uniqueConstraints = {@UniqueConstraint(columnNames = {"model_name", "producer",
        "drive_assembly_type", "const_explosion_proof"})})
@XmlRootElement
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DriveAssembly extends Equipment implements PumpPart {
    private Constant constDriveAssemblyType;
    private Constant constExplosionProof;
    private Set<Pump> suitablePumps;

    public DriveAssembly() {
    }

    public DriveAssembly(Producer producer, String modelName, BigDecimal price, Constant constDriveAssemblyType,
                         Constant constExplosionProof, Set<Pump> suitablePumps) {
        this.setProducer(producer);
        this.setModelName(modelName);
        this.setPrice(price);
        this.constDriveAssemblyType = constDriveAssemblyType;
        this.constExplosionProof = constExplosionProof;
        this.suitablePumps = suitablePumps;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "drive_assembly_type")
    public Constant getConstDriveAssemblyType() {
        return constDriveAssemblyType;
    }

    public void setConstDriveAssemblyType(Constant constDriveAssemblyType) {
        this.constDriveAssemblyType = constDriveAssemblyType;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "const_explosion_proof")
    public Constant getConstExplosionProof() {
        return constExplosionProof;
    }

    public void setConstExplosionProof(Constant constExplosionProof) {
        this.constExplosionProof = constExplosionProof;
    }

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

        DriveAssembly that = (DriveAssembly) o;

        return constDriveAssemblyType.equals(that.constDriveAssemblyType) && constExplosionProof.equals(that.constExplosionProof);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + constDriveAssemblyType.hashCode();
        result = 31 * result + constExplosionProof.hashCode();
        return result;
    }
}

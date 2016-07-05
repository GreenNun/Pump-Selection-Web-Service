package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Producer;

import javax.persistence.*;
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
 * value:  "Pump Adder" | "Coupling" | "Flexible Coupling" | "Belt and Pulley";
 * <p>
 * constExplosionProof      name:   "explosion proof";
 * value:  "none" | "ATEX";
 */
@Entity
@Table(name = "TB_DRIVER_ASSEMBLIES", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer",
        "driver_Assembly_Type", "const_Explosion_Proof", "suitable_Pump"})})
public class DriverAssembly extends Equipment {
    private Constant driverAssemblyType;
    private Constant constExplosionProof;
    private Pump suitablePump;

    public DriverAssembly() {
    }

    public DriverAssembly(Producer producer, String modelName, BigDecimal price, Constant driverAssemblyType,
                          Constant constExplosionProof, Pump suitablePump) {
        this.setProducer(producer);
        this.setModelName(modelName);
        this.setPrice(price);
        this.driverAssemblyType = driverAssemblyType;
        this.constExplosionProof = constExplosionProof;
        this.suitablePump = suitablePump;
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

    @ManyToOne(optional = false)
    public Pump getSuitablePump() {
        return suitablePump;
    }

    public void setSuitablePump(Pump suitablePump) {
        this.suitablePump = suitablePump;
    }
}

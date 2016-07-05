package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TB_COUPLINGS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer",
        "driver_Assembly_Type", "suitable_Pump"})})
public class DriverAssembly extends Equipment {
    private Constant driverAssemblyType;
    private Pump suitablePump;

    @ManyToOne(optional = false)
    public Constant getDriverAssemblyType() {
        return driverAssemblyType;
    }

    public void setDriverAssemblyType(Constant driverAssemblyType) {
        this.driverAssemblyType = driverAssemblyType;
    }

    @ManyToOne(optional = false)
    public Pump getSuitablePump() {
        return suitablePump;
    }

    public void setSuitablePump(Pump suitablePump) {
        this.suitablePump = suitablePump;
    }
}

package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_INT_GEAR_PUMPS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class InternalGearPump extends Pump {
    private Constant rotorGearMaterial;
    private Constant idlerGearMaterial;
    private Constant bushingMaterial;
//    private Boolean isPressureReliefValve;
//    private Boolean isCoverHeatingJacket;
//    private Boolean isCastingHeatingJacket;
//    private Boolean isBracketHeatingJacket;

    @ManyToOne(optional = false)
    public Constant getRotorGearMaterial() {
        return rotorGearMaterial;
    }

    public void setRotorGearMaterial(Constant rotorGearMaterial) {
        this.rotorGearMaterial = rotorGearMaterial;
    }

    @ManyToOne(optional = false)
    public Constant getIdlerGearMaterial() {
        return idlerGearMaterial;
    }

    public void setIdlerGearMaterial(Constant idlerGearMaterial) {
        this.idlerGearMaterial = idlerGearMaterial;
    }

    @ManyToOne(optional = false)
    public Constant getBushingMaterial() {
        return bushingMaterial;
    }

    public void setBushingMaterial(Constant bushingMaterial) {
        this.bushingMaterial = bushingMaterial;
    }
}

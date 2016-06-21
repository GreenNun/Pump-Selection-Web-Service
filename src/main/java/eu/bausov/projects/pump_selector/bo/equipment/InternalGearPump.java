package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.SpeedCorrectionCoefficient;

import javax.persistence.*;
import java.util.TreeSet;

@Entity
@Table(name = "TB_INTERNAL_GEAR_PUMPS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class InternalGearPump extends Pump {
    private Constant rotorGearMaterial;
    private Constant idlerGearMaterial;
    private Constant bushingMaterial;
    private Double rpmCoefficient;
    private TreeSet<SpeedCorrectionCoefficient> speedCorrectionCoefficients;

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

    @Basic(optional = false)
    public Double getRpmCoefficient() {
        return rpmCoefficient;
    }

    public void setRpmCoefficient(Double rpmCoefficient) {
        this.rpmCoefficient = rpmCoefficient;
    }

    // TODO: 21.06.2016 annotations
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @MapKey(name = "viscosity")
    public TreeSet<SpeedCorrectionCoefficient> getSpeedCorrectionCoefficients() {
        return speedCorrectionCoefficients;
    }

    public void setSpeedCorrectionCoefficients(TreeSet<SpeedCorrectionCoefficient> speedCorrectionCoefficients) {
        this.speedCorrectionCoefficients = speedCorrectionCoefficients;
    }
}

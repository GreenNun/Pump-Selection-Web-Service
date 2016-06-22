package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Parameters;
import eu.bausov.projects.pump_selector.bo.SpeedCorrectionCoefficient;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

/**
 * Bareshafted internal gear pump (pump head).
 */
@Entity
@Table(name = "TB_INTERNAL_GEAR_PUMPS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})})
public class InternalGearPump extends Pump {
    private Constant rotorGearMaterial;
    private Constant idlerGearMaterial;
    private Constant bushingMaterial;
    private Double rpmCoefficient;
    private Set<SpeedCorrectionCoefficient> speedCorrectionCoefficients;

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
    public Set<SpeedCorrectionCoefficient> getSpeedCorrectionCoefficients() {
        return speedCorrectionCoefficients;
    }

    public void setSpeedCorrectionCoefficients(Set<SpeedCorrectionCoefficient> speedCorrectionCoefficients) {
        this.speedCorrectionCoefficients = speedCorrectionCoefficients;
    }

    /**
     * Checks reducer to be used with current pump and parameters.
     *
     * @param r Reducer instance to take motor power used with.
     * @param p Parameters instance to take required motor standard power [HP] value.
     * @return true if passed reducer can be used with current pump for passed parameters.
     */
    public boolean isSuitableReducer(Reducer r, Parameters p){
        return r.getSpeedRange().contains(getShaftSpeed(p)) &&
                (p.getRequiredMotorStandardPowerHP() == Double.parseDouble(r.getSuitablePowerHp().getValue())); /// and power
    }

    /**
     * Calculates pump shaft speed for required parameters. Formula y = x * a + b, where:
     * y [rpm] - shaft speed;
     * x [m3/h] - capacity;
     * a - capacity coefficient;
     * b - speed correction coefficient by viscosity.
     *
     * @param p    Parameters instance to take capacity, got from user
     * @return int value of shaft speed
     */
    private int getShaftSpeed(Parameters p) {
        double q = p.getCapacity();
        double c1 = rpmCoefficient;
        int c2 = getSpeedCorrectionCoefficient(p);
        return (int) (q * c1) + c2;
    }

    /**
     * Finds speed correction coefficient that belongs to viscosity value in Parameters object.
     *
     * @param p   Parameters instance to take viscosity value
     * @return int value of speedCorrectionCoefficient of 0 if set is empty
     */
    private int getSpeedCorrectionCoefficient(Parameters p) {
        Optional<SpeedCorrectionCoefficient> optional = speedCorrectionCoefficients.stream().sorted().filter((s) ->
                s.getViscosity() >= p.getViscosity()).findFirst();
        if (optional.isPresent()) {
            return optional.get().getCoefficient();
        }
        return 0;
    }
}

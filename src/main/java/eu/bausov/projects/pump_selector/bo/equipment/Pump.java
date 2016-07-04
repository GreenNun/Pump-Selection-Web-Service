package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Parameters;
import eu.bausov.projects.pump_selector.bo.SpeedCorrectionCoefficient;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

/**
 * Bareshafted pump (pump head).
 * <p>
 * Constants:
 * <p>
 * constPumpType             name:   "pump type";
 * value:  "gear pump" | "internal gear pump" | "helical gear pump" | "lobe pump";
 * <p>
 * constCastingMaterial      name:   "material";
 * value:  "GG 25 Cast Iron" | "GS 45 Cast Steel" | "AISI 304 CrNi Stainless Steel" | "AISI 316 CrNi Stainless Steel";
 * <p>
 * constRotorGearMaterial    name:   "material";
 * value:  "cast iron" | "steal" | "stainless steal";
 * <p>
 * constIdlerGearMaterial    name:   "material";
 * value:  "cast iron" | "steal" | "stainless steal";
 * <p>
 * constBushingMaterial      name:   "material";
 * value:  "bronze";
 * <p>
 * constShaftMaterial        name:   "material";
 * value:  "heat treating steal";
 * <p>
 * constConnectionsType      name:   "connections type";
 * value:  "thread" | "flange";
 * <p>
 * constDn                   name:   "constDn";
 * value:  "3 inch" | "3.5 inch" | "4 inch" | ... ;
 * <p>
 * constMaxPressure          name:   "pressure";
 * value:  "10" | "12";
 * <p>
 * constConnectionsAngle     name:   "connections angle";
 * value:  "90" | "180";
 * <p>
 * constMaxTemperature       name:   "temperature";
 * value:  "180" | "200" | "220";
 */
@Entity
@Table(name = "TB_PUMPS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer", "isReliefValve",
        "isHeatingJacketOnCover", "isHeatingJacketOnCasting", "isHeatingJacketOnBracket", "seal", "constCastingMaterial",
        "constRotorGearMaterial", "constIdlerGearMaterial", "constShaftSupportMaterial", "constShaftMaterial",
        "constConnectionsType", "constDn", "constMaxPressure", "constConnectionsAngle", "constMaxTemperature",
        "rpmCoefficient", "speedCorrectionCoefficients"})})
public class Pump extends Equipment {
    private Constant constPumpType;
    private Boolean isReliefValve;
    private Boolean isHeatingJacketOnCover;
    private Boolean isHeatingJacketOnCasting;
    private Boolean isHeatingJacketOnBracket;

    private Seal seal;

    private Constant constCastingMaterial;
    private Constant constRotorGearMaterial;
    private Constant constIdlerGearMaterial;
    private Constant constShaftSupportMaterial;
    private Constant constShaftMaterial;

    private Constant constConnectionsType;
    private Constant constDn;
    private Constant constMaxPressure;
    private Constant constConnectionsAngle;
    private Constant constMaxTemperature;

    private Double rpmCoefficient;
    private Set<SpeedCorrectionCoefficient> speedCorrectionCoefficients;

    @ManyToOne(optional = false)
    public Constant getConstPumpType() {
        return constPumpType;
    }

    public void setConstPumpType(Constant constPumpType) {
        this.constPumpType = constPumpType;
    }

    @Basic(optional = false)
    public Boolean getReliefValve() {
        return isReliefValve;
    }

    public void setReliefValve(Boolean reliefValve) {
        isReliefValve = reliefValve;
    }

    @Basic(optional = false)
    public Boolean getHeatingJacketOnCover() {
        return isHeatingJacketOnCover;
    }

    public void setHeatingJacketOnCover(Boolean heatingJacketOnCover) {
        isHeatingJacketOnCover = heatingJacketOnCover;
    }

    @Basic(optional = false)
    public Boolean getHeatingJacketOnCasting() {
        return isHeatingJacketOnCasting;
    }

    public void setHeatingJacketOnCasting(Boolean heatingJacketOnCasting) {
        isHeatingJacketOnCasting = heatingJacketOnCasting;
    }

    @Basic(optional = false)
    public Boolean getHeatingJacketOnBracket() {
        return isHeatingJacketOnBracket;
    }

    public void setHeatingJacketOnBracket(Boolean heatingJacketOnBracket) {
        isHeatingJacketOnBracket = heatingJacketOnBracket;
    }

    @ManyToOne(optional = false)
    public Seal getSeal() {
        return seal;
    }

    public void setSeal(Seal seal) {
        this.seal = seal;
    }

    @ManyToOne(optional = false)
    public Constant getConstCastingMaterial() {
        return constCastingMaterial;
    }

    public void setConstCastingMaterial(Constant constCastingMaterial) {
        this.constCastingMaterial = constCastingMaterial;
    }

    @ManyToOne(optional = false)
    public Constant getConstRotorGearMaterial() {
        return constRotorGearMaterial;
    }

    public void setConstRotorGearMaterial(Constant constRotorGearMaterial) {
        this.constRotorGearMaterial = constRotorGearMaterial;
    }

    @ManyToOne(optional = false)
    public Constant getConstIdlerGearMaterial() {
        return constIdlerGearMaterial;
    }

    public void setConstIdlerGearMaterial(Constant constIdlerGearMaterial) {
        this.constIdlerGearMaterial = constIdlerGearMaterial;
    }

    @ManyToOne(optional = false)
    public Constant getConstShaftSupportMaterial() {
        return constShaftSupportMaterial;
    }

    public void setConstShaftSupportMaterial(Constant constShaftSupportMaterial) {
        this.constShaftSupportMaterial = constShaftSupportMaterial;
    }

    @ManyToOne(optional = false)
    public Constant getConstShaftMaterial() {
        return constShaftMaterial;
    }

    public void setConstShaftMaterial(Constant constShaftMaterial) {
        this.constShaftMaterial = constShaftMaterial;
    }

    @ManyToOne(optional = false)
    public Constant getConstConnectionsType() {
        return constConnectionsType;
    }

    public void setConstConnectionsType(Constant constConnectionsType) {
        this.constConnectionsType = constConnectionsType;
    }

    @ManyToOne(optional = false)
    public Constant getConstDn() {
        return constDn;
    }

    public void setConstDn(Constant constDn) {
        this.constDn = constDn;
    }

    @ManyToOne(optional = false)
    public Constant getConstMaxPressure() {
        return constMaxPressure;
    }

    public void setConstMaxPressure(Constant constMaxPressure) {
        this.constMaxPressure = constMaxPressure;
    }

    @ManyToOne(optional = false)
    public Constant getConstConnectionsAngle() {
        return constConnectionsAngle;
    }

    public void setConstConnectionsAngle(Constant constConnectionsAngle) {
        this.constConnectionsAngle = constConnectionsAngle;
    }

    @ManyToOne(optional = false)
    public Constant getConstMaxTemperature() {
        return constMaxTemperature;
    }

    public void setConstMaxTemperature(Constant constMaxTemperature) {
        this.constMaxTemperature = constMaxTemperature;
    }

    @Basic(optional = false)
    public Double getRpmCoefficient() {
        return rpmCoefficient;
    }

    public void setRpmCoefficient(Double rpmCoefficient) {
        this.rpmCoefficient = rpmCoefficient;
    }

    @ManyToMany(fetch = FetchType.EAGER)
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
    public boolean isReducerValid(Reducer r, Parameters p) {
        return r.getSpeedRange().contains(getShaftSpeed(p)) &&
                (p.getRequiredMotorStandardPowerHP() == r.getConstRequiredMotorPowerHp().getDoubleValue());
    }

    /**
     * Calculates pump shaft speed for required parameters. Formula y = x * a + b, where:
     * y [rpm] - shaft speed;
     * x [m3/h] - capacity;
     * a - capacity coefficient;
     * b - speed correction coefficient by viscosity.
     *
     * @param p Parameters instance to take capacity, got from user
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
     * @param p Parameters instance to take viscosity value
     * @return int value of speedCorrectionCoefficient, 0 if set is empty
     */
    private int getSpeedCorrectionCoefficient(Parameters p) {
        Optional<SpeedCorrectionCoefficient> optional = speedCorrectionCoefficients.stream().sorted().filter((s) ->
                s.getViscosity() >= p.getViscosity()).findFirst();
        if (optional.isPresent()) {
            return optional.get().getCoefficient();
        }
        return 0;
    }

    /**
     * Checks pressure value in parameters for current pump pressure limit.
     *
     * @param parameters Parameters instance to take comprising pressure value.
     * @return Returns true if pressure limit is not exceeded.
     */
    public boolean isPressureValid(Parameters parameters) {
        return getConstMaxPressure().getIntegerValue() <= parameters.getPressure();
    }

    /**
     * Checks temperature value in parameters for current pump temperature limit.
     *
     * @param parameters Parameters instance to take comprising temperature value.
     * @return Returns true if temperature limit is not exceeded.
     */
    public boolean isTemperatureValid(Parameters parameters) {
        return getConstMaxTemperature().getIntegerValue() <= parameters.getTemperature();
    }
}

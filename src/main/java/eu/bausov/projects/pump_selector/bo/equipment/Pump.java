package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Parameters;
import eu.bausov.projects.pump_selector.bo.SpeedCorrectionCoefficient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

/**
 * Bareshafted pump (pump head).
 * <p>
 * Constants:
 * <p>
 * constPumpType             name:   "pump type";
 * value:  "Modular Gear Pump" | "Internal Eccentric Gear Pump" | "Helical Gear Pump" | "Lobe Pump" | "Food Pump";
 * <p>
 * constCasingMaterial      name:   "material";
 * value:  "GG 25 Cast Iron" | "GS 45 Cast Steel" | "AISI 304 CrNi Stainless Steel" | "AISI 316 CrNi Stainless Steel";
 * <p>
 * constRotorGearMaterial    name:   "material";
 * value:  "GGG 40 Cast Iron" | "GS 45 Cast Steel" | "AISI 304 CrNi Stainless Steel" | "AISI 316 CrNi Stainless Steel" |
 *         "8620 Steel, Heat Treated";
 * <p>
 * constIdlerGearMaterial    name:   "material";
 * value:  "GGG 40 Cast Iron" | "GS 45 Cast Steel" | "AISI 304 CrNi Stainless Steel" | "AISI 316 CrNi Stainless Steel" |
 *         "8620 Steel, Heat Treated";
 * <p>
 * constShaftSupportMaterial name:   "material";
 * value:  "CuSn 12 Bronze Bushings" | "Carbon Graphite Bushings" | "Ball Bearings";
 * <p>
 * constShaftMaterial        name:   "material";
 * value:  "1050 Steel, Heat Treated" | "AISI 304 CrNi Stainless Steel" | "AISI 316 CrNi Stainless Steel" |
 *         "8620 Steel, Heat Treated";
 * <p>
 * constConnectionsType      name:   "connections type";
 * value:  "Thread" | "Flange" | "Pipe Toothed";
 * <p>
 * constDn                   name:   "DN";
 * value:  "20" | "25" | "40" | "50"  | "65" | "80" | "100" | "125" | "200";
 * <p>
 * constMaxPressure          name:   "max. pressure";
 * value:  "10" | "12" | "14";
 * <p>
 * constConnectionsAngle     name:   "connections angle";
 * value:  "90" | "180";
 * <p>
 * constMaxTemperature       name:   "max. temperature";
 * value:  "180" | "200" | "220";
 * <p>
 * rpmCoefficient is ratio coefficient between Capacity [m3/h] and Shaft Rotations [rpm].
 * <p>
 * speedCorrectionCoefficients is pumps of coefficients correcting shaft speed according viscosity grades.
 */
@Entity
@Table(name = "TB_PUMPS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer", "const_Pump_Type",
        "ReliefValve", "HeatingJacketOnCover", "HeatingJacketOnCasing", "HeatingJacketOnBracket",
        "const_Casing_Material", "const_Rotor_Gear_Material", "const_Idler_Gear_Material", "const_Shaft_Support_Material",
        "const_Shaft_Material", "const_Connections_Type", "const_Dn", "const_Max_Pressure", "const_Connections_Angle"})})
@XmlRootElement
public class Pump extends Equipment {
    private Constant constPumpType;
    private Boolean isReliefValve;
    private Boolean isHeatingJacketOnCover;
    private Boolean isHeatingJacketOnCasing;
    private Boolean isHeatingJacketOnBracket;

    private Constant constCasingMaterial;
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
    public Boolean getHeatingJacketOnCasing() {
        return isHeatingJacketOnCasing;
    }

    public void setHeatingJacketOnCasing(Boolean heatingJacketOnCasing) {
        isHeatingJacketOnCasing = heatingJacketOnCasing;
    }

    @Basic(optional = false)
    public Boolean getHeatingJacketOnBracket() {
        return isHeatingJacketOnBracket;
    }

    public void setHeatingJacketOnBracket(Boolean heatingJacketOnBracket) {
        isHeatingJacketOnBracket = heatingJacketOnBracket;
    }

    @ManyToOne(optional = false)
    public Constant getConstCasingMaterial() {
        return constCasingMaterial;
    }

    public void setConstCasingMaterial(Constant constCasingMaterial) {
        this.constCasingMaterial = constCasingMaterial;
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

    @XmlTransient
    @Fetch(FetchMode.SUBSELECT)
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
        return r.getMinRpm() <= (getShaftSpeed(p)) && r.getMaxRpm() >= (getShaftSpeed(p)) &&
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
    public int getShaftSpeed(Parameters p) {
        double q = p.getCapacity();
        double c1 = rpmCoefficient;
        int c2 = getSpeedCorrectionCoefficient(p);
        return (int) (q * c1) + c2;
    }

    /**
     * Finds speed correction coefficient that belongs to viscosity value in Parameters object.
     *
     * @param p Parameters instance to take viscosity value
     * @return int value of speedCorrectionCoefficient, 0 if pumps is empty
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
        return getConstMaxPressure().getIntegerValue() >= parameters.getPressure();
    }

    /**
     * Checks temperature value in parameters for current pump temperature limit.
     *
     * @param parameters Parameters instance to take comprising temperature value.
     * @return Returns true if temperature limit is not exceeded.
     */
    public boolean isTemperatureValid(Parameters parameters) {
        return getConstMaxTemperature().getIntegerValue() >= parameters.getTemperature();
    }

    /**
     * // TODO: 13.07.2016  
     * @param parameters
     * @return
     */
    public boolean isViscosityValid(Parameters parameters) {
        Optional<SpeedCorrectionCoefficient> max = getSpeedCorrectionCoefficients().stream()
                .max((o1, o2) -> o1.getViscosity().compareTo(o2.getViscosity()));
        return max.isPresent() && max.get().getViscosity() >= parameters.getViscosity();
    }

    /**
     * Finds equivalent of current pump in passed pump pumps. Method uses to check
     *
     * @param pumps Set of pumps.
     * @return Returns true if equivalent of current pump is found.
     */
    public boolean isValidTo(Set<Pump> pumps){
        for (Pump pump : pumps){
            if (this.equals(pump)) return true;
        }
        return false;
    }
}

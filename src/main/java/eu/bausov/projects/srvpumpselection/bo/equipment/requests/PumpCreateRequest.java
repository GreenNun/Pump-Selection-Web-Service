package eu.bausov.projects.srvpumpselection.bo.equipment.requests;

import eu.bausov.projects.srvpumpselection.bo.SpeedCorrectionCoefficient;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Set;

@XmlRootElement
public class PumpCreateRequest {
    private String modelName;
    private long producer;
    private BigDecimal price;

    private long constPumpType;
    private boolean isReliefValve;
    private boolean isHeatingJacketOnCover;
    private boolean isHeatingJacketOnCasing;
    private boolean isHeatingJacketOnBracket;

    private long constCasingMaterial;
    private long constRotorGearMaterial;
    private long constIdlerGearMaterial;
    private long constShaftSupportMaterial;
    private long constShaftMaterial;

    private long constConnectionsType;
    private long constDn;
    private long constMaxPressure;
    private long constConnectionsAngle;
    private long constMaxTemperature;

    private double rpmCoefficient;
    private Set<SpeedCorrectionCoefficient> speedCorrectionCoefficients;
    private long[] seals;
    private long[] frames;
    private long[] driverAssemblies;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public long getProducer() {
        return producer;
    }

    public void setProducer(long producer) {
        this.producer = producer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getConstPumpType() {
        return constPumpType;
    }

    public void setConstPumpType(long constPumpType) {
        this.constPumpType = constPumpType;
    }

    public boolean isReliefValve() {
        return isReliefValve;
    }

    public void setReliefValve(boolean reliefValve) {
        isReliefValve = reliefValve;
    }

    public boolean isHeatingJacketOnCover() {
        return isHeatingJacketOnCover;
    }

    public void setHeatingJacketOnCover(boolean heatingJacketOnCover) {
        isHeatingJacketOnCover = heatingJacketOnCover;
    }

    public boolean isHeatingJacketOnCasing() {
        return isHeatingJacketOnCasing;
    }

    public void setHeatingJacketOnCasing(boolean heatingJacketOnCasing) {
        isHeatingJacketOnCasing = heatingJacketOnCasing;
    }

    public boolean isHeatingJacketOnBracket() {
        return isHeatingJacketOnBracket;
    }

    public void setHeatingJacketOnBracket(boolean heatingJacketOnBracket) {
        isHeatingJacketOnBracket = heatingJacketOnBracket;
    }

    public long getConstCasingMaterial() {
        return constCasingMaterial;
    }

    public void setConstCasingMaterial(long constCasingMaterial) {
        this.constCasingMaterial = constCasingMaterial;
    }

    public long getConstRotorGearMaterial() {
        return constRotorGearMaterial;
    }

    public void setConstRotorGearMaterial(long constRotorGearMaterial) {
        this.constRotorGearMaterial = constRotorGearMaterial;
    }

    public long getConstIdlerGearMaterial() {
        return constIdlerGearMaterial;
    }

    public void setConstIdlerGearMaterial(long constIdlerGearMaterial) {
        this.constIdlerGearMaterial = constIdlerGearMaterial;
    }

    public long getConstShaftSupportMaterial() {
        return constShaftSupportMaterial;
    }

    public void setConstShaftSupportMaterial(long constShaftSupportMaterial) {
        this.constShaftSupportMaterial = constShaftSupportMaterial;
    }

    public long getConstShaftMaterial() {
        return constShaftMaterial;
    }

    public void setConstShaftMaterial(long constShaftMaterial) {
        this.constShaftMaterial = constShaftMaterial;
    }

    public long getConstConnectionsType() {
        return constConnectionsType;
    }

    public void setConstConnectionsType(long constConnectionsType) {
        this.constConnectionsType = constConnectionsType;
    }

    public long getConstDn() {
        return constDn;
    }

    public void setConstDn(long constDn) {
        this.constDn = constDn;
    }

    public long getConstMaxPressure() {
        return constMaxPressure;
    }

    public void setConstMaxPressure(long constMaxPressure) {
        this.constMaxPressure = constMaxPressure;
    }

    public long getConstConnectionsAngle() {
        return constConnectionsAngle;
    }

    public void setConstConnectionsAngle(long constConnectionsAngle) {
        this.constConnectionsAngle = constConnectionsAngle;
    }

    public long getConstMaxTemperature() {
        return constMaxTemperature;
    }

    public void setConstMaxTemperature(long constMaxTemperature) {
        this.constMaxTemperature = constMaxTemperature;
    }

    public double getRpmCoefficient() {
        return rpmCoefficient;
    }

    public void setRpmCoefficient(double rpmCoefficient) {
        this.rpmCoefficient = rpmCoefficient;
    }

    public Set<SpeedCorrectionCoefficient> getSpeedCorrectionCoefficients() {
        return speedCorrectionCoefficients;
    }

    public void setSpeedCorrectionCoefficients(Set<SpeedCorrectionCoefficient> speedCorrectionCoefficients) {
        this.speedCorrectionCoefficients = speedCorrectionCoefficients;
    }

    public long[] getSeals() {
        return seals;
    }

    public void setSeals(long[] seals) {
        this.seals = seals;
    }

    public long[] getFrames() {
        return frames;
    }

    public void setFrames(long[] frames) {
        this.frames = frames;
    }

    public long[] getDriverAssemblies() {
        return driverAssemblies;
    }

    public void setDriverAssemblies(long[] driverAssemblies) {
        this.driverAssemblies = driverAssemblies;
    }
}

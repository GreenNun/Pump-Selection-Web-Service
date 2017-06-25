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
    private long[] driveAssemblies;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public long getProducerId() {
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

    public long getConstPumpTypeId() {
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

    public long getConstCasingMaterialId() {
        return constCasingMaterial;
    }

    public void setConstCasingMaterial(long constCasingMaterial) {
        this.constCasingMaterial = constCasingMaterial;
    }

    public long getConstRotorGearMaterialId() {
        return constRotorGearMaterial;
    }

    public void setConstRotorGearMaterial(long constRotorGearMaterial) {
        this.constRotorGearMaterial = constRotorGearMaterial;
    }

    public long getConstIdlerGearMaterialId() {
        return constIdlerGearMaterial;
    }

    public void setConstIdlerGearMaterial(long constIdlerGearMaterial) {
        this.constIdlerGearMaterial = constIdlerGearMaterial;
    }

    public long getConstShaftSupportMaterialId() {
        return constShaftSupportMaterial;
    }

    public void setConstShaftSupportMaterial(long constShaftSupportMaterial) {
        this.constShaftSupportMaterial = constShaftSupportMaterial;
    }

    public long getConstShaftMaterialId() {
        return constShaftMaterial;
    }

    public void setConstShaftMaterial(long constShaftMaterial) {
        this.constShaftMaterial = constShaftMaterial;
    }

    public long getConstConnectionsTypeId() {
        return constConnectionsType;
    }

    public void setConstConnectionsType(long constConnectionsType) {
        this.constConnectionsType = constConnectionsType;
    }

    public long getConstDnId() {
        return constDn;
    }

    public void setConstDn(long constDn) {
        this.constDn = constDn;
    }

    public long getConstMaxPressureId() {
        return constMaxPressure;
    }

    public void setConstMaxPressure(long constMaxPressure) {
        this.constMaxPressure = constMaxPressure;
    }

    public long getConstConnectionsAngleId() {
        return constConnectionsAngle;
    }

    public void setConstConnectionsAngle(long constConnectionsAngle) {
        this.constConnectionsAngle = constConnectionsAngle;
    }

    public long getConstMaxTemperatureId() {
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

    public long[] getSealsIdentifires() {
        return seals;
    }

    public void setSeals(long[] seals) {
        this.seals = seals;
    }

    public long[] getFramesIdentifires() {
        return frames;
    }

    public void setFrames(long[] frames) {
        this.frames = frames;
    }

    public long[] getDriveAssembliesIdentifires() {
        return driveAssemblies;
    }

    public void setDriveAssemblies(long[] driveAssemblies) {
        this.driveAssemblies = driveAssemblies;
    }
}

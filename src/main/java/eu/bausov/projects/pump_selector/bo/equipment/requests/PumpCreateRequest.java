package eu.bausov.projects.pump_selector.bo.equipment.requests;

import eu.bausov.projects.pump_selector.bo.Constant;
import eu.bausov.projects.pump_selector.bo.Producer;
import eu.bausov.projects.pump_selector.bo.SpeedCorrectionCoefficient;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Set;

@XmlRootElement
public class PumpCreateRequest {
    private String modelName;
    private Long producer;
    private BigDecimal price;

    private Long constPumpType;
    private Boolean isReliefValve;
    private Boolean isHeatingJacketOnCover;
    private Boolean isHeatingJacketOnCasing;
    private Boolean isHeatingJacketOnBracket;

    private Long constCasingMaterial;
    private Long constRotorGearMaterial;
    private Long constIdlerGearMaterial;
    private Long constShaftSupportMaterial;
    private Long constShaftMaterial;

    private Long constConnectionsType;
    private Long constDn;
    private Long constMaxPressure;
    private Long constConnectionsAngle;
    private Long constMaxTemperature;

    private Double rpmCoefficient;
    private Set<SpeedCorrectionCoefficient> speedCorrectionCoefficients;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Long getProducer() {
        return producer;
    }

    public void setProducer(Long producer) {
        this.producer = producer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getConstPumpType() {
        return constPumpType;
    }

    public void setConstPumpType(Long constPumpType) {
        this.constPumpType = constPumpType;
    }

    public Boolean getReliefValve() {
        return isReliefValve;
    }

    public void setReliefValve(Boolean reliefValve) {
        isReliefValve = reliefValve;
    }

    public Boolean getHeatingJacketOnCover() {
        return isHeatingJacketOnCover;
    }

    public void setHeatingJacketOnCover(Boolean heatingJacketOnCover) {
        isHeatingJacketOnCover = heatingJacketOnCover;
    }

    public Boolean getHeatingJacketOnCasing() {
        return isHeatingJacketOnCasing;
    }

    public void setHeatingJacketOnCasing(Boolean heatingJacketOnCasing) {
        isHeatingJacketOnCasing = heatingJacketOnCasing;
    }

    public Boolean getHeatingJacketOnBracket() {
        return isHeatingJacketOnBracket;
    }

    public void setHeatingJacketOnBracket(Boolean heatingJacketOnBracket) {
        isHeatingJacketOnBracket = heatingJacketOnBracket;
    }

    public Long getConstCasingMaterial() {
        return constCasingMaterial;
    }

    public void setConstCasingMaterial(Long constCasingMaterial) {
        this.constCasingMaterial = constCasingMaterial;
    }

    public Long getConstRotorGearMaterial() {
        return constRotorGearMaterial;
    }

    public void setConstRotorGearMaterial(Long constRotorGearMaterial) {
        this.constRotorGearMaterial = constRotorGearMaterial;
    }

    public Long getConstIdlerGearMaterial() {
        return constIdlerGearMaterial;
    }

    public void setConstIdlerGearMaterial(Long constIdlerGearMaterial) {
        this.constIdlerGearMaterial = constIdlerGearMaterial;
    }

    public Long getConstShaftSupportMaterial() {
        return constShaftSupportMaterial;
    }

    public void setConstShaftSupportMaterial(Long constShaftSupportMaterial) {
        this.constShaftSupportMaterial = constShaftSupportMaterial;
    }

    public Long getConstShaftMaterial() {
        return constShaftMaterial;
    }

    public void setConstShaftMaterial(Long constShaftMaterial) {
        this.constShaftMaterial = constShaftMaterial;
    }

    public Long getConstConnectionsType() {
        return constConnectionsType;
    }

    public void setConstConnectionsType(Long constConnectionsType) {
        this.constConnectionsType = constConnectionsType;
    }

    public Long getConstDn() {
        return constDn;
    }

    public void setConstDn(Long constDn) {
        this.constDn = constDn;
    }

    public Long getConstMaxPressure() {
        return constMaxPressure;
    }

    public void setConstMaxPressure(Long constMaxPressure) {
        this.constMaxPressure = constMaxPressure;
    }

    public Long getConstConnectionsAngle() {
        return constConnectionsAngle;
    }

    public void setConstConnectionsAngle(Long constConnectionsAngle) {
        this.constConnectionsAngle = constConnectionsAngle;
    }

    public Long getConstMaxTemperature() {
        return constMaxTemperature;
    }

    public void setConstMaxTemperature(Long constMaxTemperature) {
        this.constMaxTemperature = constMaxTemperature;
    }

    public Double getRpmCoefficient() {
        return rpmCoefficient;
    }

    public void setRpmCoefficient(Double rpmCoefficient) {
        this.rpmCoefficient = rpmCoefficient;
    }

    public Set<SpeedCorrectionCoefficient> getSpeedCorrectionCoefficients() {
        return speedCorrectionCoefficients;
    }

    public void setSpeedCorrectionCoefficients(Set<SpeedCorrectionCoefficient> speedCorrectionCoefficients) {
        this.speedCorrectionCoefficients = speedCorrectionCoefficients;
    }
}

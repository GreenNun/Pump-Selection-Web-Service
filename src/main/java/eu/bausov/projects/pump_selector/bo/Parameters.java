package eu.bausov.projects.pump_selector.bo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@XmlRootElement
public class Parameters extends JPA {
    private String medium;
    private String pumpType;
    private Double capacity;
    private Integer pressure;
    private Integer viscosity;
    private Double sg;
    private Integer temperature;
    private String castingMaterial;
    private String sealType;
    private String driverAssemblyType;
    private Boolean isReliefValve;
    private Boolean isHeatingJacket;
    private Boolean isExplosionProof;

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getPumpType() {
        return pumpType;
    }

    public void setPumpType(String pumpType) {
        this.pumpType = pumpType;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getViscosity() {
        return viscosity;
    }

    public void setViscosity(Integer viscosity) {
        this.viscosity = viscosity;
    }

    public Double getSg() {
        return sg;
    }

    public void setSg(Double sg) {
        this.sg = sg;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getCastingMaterial() {
        return castingMaterial;
    }

    public void setCastingMaterial(String castingMaterial) {
        this.castingMaterial = castingMaterial;
    }

    public String getSealType() {
        return sealType;
    }

    public void setSealType(String sealType) {
        this.sealType = sealType;
    }

    public String getDriverAssemblyType() {
        return driverAssemblyType;
    }

    public void setDriverAssemblyType(String driverAssemblyType) {
        this.driverAssemblyType = driverAssemblyType;
    }

    public Boolean getReliefValve() {
        return isReliefValve;
    }

    public void setReliefValve(Boolean reliefValve) {
        isReliefValve = reliefValve;
    }

    public Boolean getHeatingJacket() {
        return isHeatingJacket;
    }

    public void setHeatingJacket(Boolean heatingJacket) {
        isHeatingJacket = heatingJacket;
    }

    public Boolean getExplosionProof() {
        return isExplosionProof;
    }

    public void setExplosionProof(Boolean explosionProof) {
        isExplosionProof = explosionProof;
    }

    /**
     * Selects standard motor power. Example: 2, 3, 5.5, 30 and etc.
     *
     * @return standard motor power in HP, if there no suitable motor, returns -1 (if required more them 250 hp).
     */
    //@Transient
    public double getRequiredMotorStandardPowerHP() {
        Stream<Double> stream = Arrays.asList(0.16, 0.25, 0.34, 0.5, 0.75, 1.0, 1.5, 2.0, 3.0, 5.5,
                7.5, 10.0, 15.0, 20.0, 25.0, 30.0, 40.0, 50.0, 60.0, 75.0,
                100.0, 120.0, 150.0, 180.0, 220.0, 250.0).stream();
        Optional<Double> optional = stream.sorted().filter((d) -> d >= gerPowerHp()).findFirst();
        return optional.isPresent() ? optional.get() : -1;
    }

    /**
     * Calculates required power on pump shaft ih HP. Formula Pw[HP] = (Q[l/h] * H[m]) / 3600 * 75 * 0.45.
     * 3600 * 75 * 0.45 = 121000.
     *
     * @return power in HP.
     */
    private double gerPowerHp() {
        return (capacity * 1000 * getMetersHead()) / 121500;
    }

    /**
     * Convert bar to meter head.
     *
     * @return pressure in meters head.
     */
    //@Transient
    private double getMetersHead() {
        return pressure * 10.19977334;
    }
}
package eu.bausov.projects.srvpumpselection.bo;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Optional;
import java.util.stream.Stream;

@XmlRootElement
public class Parameters {
    private String medium;
    private String pumpType;
    private double capacity;
    private int pressure;
    private int viscosity;
    private double sg;
    private int temperature;
    private String casingMaterial;
    private String sealType;
    private String driverAssemblyType;
    private boolean isReliefValve;
    private boolean isHeatingJacket;
    private boolean isExplosionProof;

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

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getViscosity() {
        return viscosity;
    }

    public void setViscosity(int viscosity) {
        this.viscosity = viscosity;
    }

    public double getSg() {
        return sg;
    }

    public void setSg(double sg) {
        this.sg = sg;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getCasingMaterial() {
        return casingMaterial;
    }

    public void setCasingMaterial(String casingMaterial) {
        this.casingMaterial = casingMaterial;
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

    public boolean isReliefValve() {
        return isReliefValve;
    }

    public void setReliefValve(boolean reliefValve) {
        isReliefValve = reliefValve;
    }

    public boolean isHeatingJacket() {
        return isHeatingJacket;
    }

    public void setHeatingJacket(boolean heatingJacket) {
        isHeatingJacket = heatingJacket;
    }

    public boolean isExplosionProof() {
        return isExplosionProof;
    }

    public void setExplosionProof(boolean explosionProof) {
        isExplosionProof = explosionProof;
    }

    /**
     * Selects standard motor power. Example: 2, 3, 5.5, 30 and etc.
     *
     * @return standard motor power in HP, if there no suitable motor, returns -1 (if required more them 250 hp).
     */
    //@Transient
    public double getRequiredMotorStandardPowerHP() {
        Stream<Double> stream = Stream.of(0.16, 0.25, 0.34, 0.5, 0.75, 1.0, 1.5, 2.0, 3.0, 5.5,
                7.5, 10.0, 15.0, 20.0, 25.0, 30.0, 40.0, 50.0, 60.0, 75.0,
                100.0, 120.0, 150.0, 180.0, 220.0, 250.0);
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
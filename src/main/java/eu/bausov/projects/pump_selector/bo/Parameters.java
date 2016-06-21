package eu.bausov.projects.pump_selector.bo;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PARAMETERS")
public class Parameters extends JPA {
    private Double capacity;
    private Integer pressure;
    private Integer viscosity;
    private Integer temperature;

    @Basic(optional = false)
    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    @Basic(optional = false)
    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    @Basic(optional = false)
    public Integer getViscosity() {
        return viscosity;
    }

    public void setViscosity(Integer viscosity) {
        this.viscosity = viscosity;
    }

    @Basic(optional = false)
    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    /**
     * Calculates required power ih HP. Formula Pw[HP] = (Q[l/h] * H[m]) / 3600 * 75 * 0.45.
     * 3600 * 75 * 0.45 = 121000.
     * @return power in HP
     */
    private double gerRequiredPowerHp(){
        return (capacity * 1000 * getMetersHead()) / 121500;
    }

    /**
     * Convert bar to meter head.
     * @return pressure in meters head
     */
    private double getMetersHead(){
        return pressure * 10.19977334;
    }
}

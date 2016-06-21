package eu.bausov.projects.pump_selector.bo.equipment;

import eu.bausov.projects.pump_selector.bo.Constant;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pump extends Equipment {
    private Constant castingMaterial;
    private Constant shaftMaterial;
    private Constant connectionsType;
    private Constant dn;
    private Constant maxPressure; // example name: pressure value: 16
    private Constant connectionsAngle;
    private Constant maxTemperature;
    private Seal seal;

    @ManyToOne(optional = false)
    public Constant getCastingMaterial() {
        return castingMaterial;
    }

    public void setCastingMaterial(Constant castingMaterial) {
        this.castingMaterial = castingMaterial;
    }

    @ManyToOne(optional = false)
    public Constant getShaftMaterial() {
        return shaftMaterial;
    }

    public void setShaftMaterial(Constant shaftMaterial) {
        this.shaftMaterial = shaftMaterial;
    }

    @ManyToOne(optional = false)
    public Constant getConnectionsType() {
        return connectionsType;
    }

    public void setConnectionsType(Constant connectionsType) {
        this.connectionsType = connectionsType;
    }

    @ManyToOne(optional = false)
    public Constant getDn() {
        return dn;
    }

    public void setDn(Constant dn) {
        this.dn = dn;
    }

    @ManyToOne(optional = false)
    public Constant getMaxPressure() {
        return maxPressure;
    }

    public void setMaxPressure(Constant maxPressure) {
        this.maxPressure = maxPressure;
    }

    @ManyToOne(optional = false)
    public Constant getConnectionsAngle() {
        return connectionsAngle;
    }

    public void setConnectionsAngle(Constant connectionsAngle) {
        this.connectionsAngle = connectionsAngle;
    }

    @ManyToOne(optional = false)
    public Constant getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Constant maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @ManyToOne(optional = false)
    public Seal getSeal() {
        return seal;
    }

    public void setSeal(Seal seal) {
        this.seal = seal;
    }
}

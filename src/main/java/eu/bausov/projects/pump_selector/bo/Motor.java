package eu.bausov.projects.pump_selector.bo;

import javax.persistence.*;

@Entity
@Table(name = "TB_LOOKUP", uniqueConstraints = {@UniqueConstraint(columnNames = {"label"})})
public class Motor extends Equipment {

    private String label;

    private Lookup speed;
    private Lookup ip;
    private Lookup voltage;
    private Lookup explosionProof;
    private Lookup kwt;

    private Integer phases;
    private Integer poles;

    @Basic(optional = false)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @ManyToOne(optional = false)
    public Lookup getSpeed() {
        return speed;
    }

    public void setSpeed(Lookup speed) {
        this.speed = speed;
    }

    @ManyToOne(optional = false)
    public Lookup getIp() {
        return ip;
    }

    public void setIp(Lookup ip) {
        this.ip = ip;
    }

    @ManyToOne(optional = false)
    public Lookup getVoltage() {
        return voltage;
    }

    public void setVoltage(Lookup voltage) {
        this.voltage = voltage;
    }

    @ManyToOne(optional = false)
    public Lookup getExplosionProof() {
        return explosionProof;
    }

    public void setExplosionProof(Lookup explosionProof) {
        this.explosionProof = explosionProof;
    }

    @ManyToOne(optional = false)
    public Lookup getKwt() {
        return kwt;
    }

    public void setKwt(Lookup kwt) {
        this.kwt = kwt;
    }

    public Integer getPhases() {
        return phases;
    }

    public void setPhases(Integer phases) {
        this.phases = phases;
    }

    public Integer getPoles() {
        return poles;
    }

    public void setPoles(Integer poles) {
        this.poles = poles;
    }
}

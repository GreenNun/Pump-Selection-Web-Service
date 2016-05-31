package eu.bausov.projects.pump_selector.bo;

import javax.persistence.*;

@Entity
@Table(name = "TB_MOTORS", uniqueConstraints = {@UniqueConstraint(columnNames = {"modelName", "producer"})}) // label
public class Motor extends Equipment {

    //private String label;
    private Type speed;
    private Type ip;
    private Type voltage;
    private Type explosionProof;
    private Type kwt;
    private Type phases;
    private Type poles;

//    @Basic(optional = false)
//    public String getLabel() {
//        return label;
//    }

//    public void setLabel(String label) {
//        this.label = label;
//    }

    @ManyToOne(optional = false)
    public Type getSpeed() {
        return speed;
    }

    public void setSpeed(Type speed) {
        this.speed = speed;
    }

    @ManyToOne(optional = false)
    public Type getIp() {
        return ip;
    }

    public void setIp(Type ip) {
        this.ip = ip;
    }

    @ManyToOne(optional = false)
    public Type getVoltage() {
        return voltage;
    }

    public void setVoltage(Type voltage) {
        this.voltage = voltage;
    }

    @ManyToOne(optional = false)
    public Type getExplosionProof() {
        return explosionProof;
    }

    public void setExplosionProof(Type explosionProof) {
        this.explosionProof = explosionProof;
    }

    @ManyToOne(optional = false)
    public Type getKwt() {
        return kwt;
    }

    public void setKwt(Type kwt) {
        this.kwt = kwt;
    }

    @ManyToOne(optional = false)
    public Type getPhases() {
        return phases;
    }

    public void setPhases(Type phases) {
        this.phases = phases;
    }

    @ManyToOne(optional = false)
    public Type getPoles() {
        return poles;
    }

    public void setPoles(Type poles) {
        this.poles = poles;
    }
}

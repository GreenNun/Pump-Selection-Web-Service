package eu.bausov.projects.pump_selector.bo;

import javax.persistence.*;

@Entity
@Table(name = "TB_RANGES", uniqueConstraints = {@UniqueConstraint(columnNames = {"minValue", "maxValue"})})
public class Range extends JPA {
    private Integer minValue;
    private Integer maxValue;

    public Range() {
    }

    public Range(Integer minValue, Integer maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Basic(optional = false)
    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    @Basic(optional = false)
    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public boolean contains(int number){
        return (number >= minValue && number <= maxValue);
    }
}

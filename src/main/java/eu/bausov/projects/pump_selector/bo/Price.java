package eu.bausov.projects.pump_selector.bo;

import eu.bausov.projects.pump_selector.bo.Lookup;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Embeddable
public class Price {

    private BigDecimal price;
    private Lookup currency;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(optional = false)
    public Lookup getCurrency() {
        return currency;
    }

    public void setCurrency(Lookup currency) {
        this.currency = currency;
    }
}

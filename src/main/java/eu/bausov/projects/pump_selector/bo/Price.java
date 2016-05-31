package eu.bausov.projects.pump_selector.bo;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Embeddable
public class Price {

    private BigDecimal price;
    private Type currency;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(optional = false)
    public Type getCurrency() {
        return currency;
    }

    public void setCurrency(Type currency) {
        this.currency = currency;
    }
}

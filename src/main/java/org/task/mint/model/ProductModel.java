package org.task.mint.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ProductModel {

    private String description;
    private String features;
    private BigDecimal costPrice;
    private BigDecimal sellingPrice;
    private Integer orders;
    private Date lastOrder;
    private Integer remainingQuantity;
    private Date creationDate;
    private Boolean enabled;
    private Integer adminId;
    private Integer categoryId;
    private Integer brandId;

    public ProductModel() {

    }

    public boolean isInValidState() {
        Integer result = 1;

        result *= ((adminId == null) ? 0 : adminId.hashCode());

        result *= ((creationDate == null) ? 0 : 1);
        result *= ((enabled == null) ? 0 : 1);
        result *= ((features == null) ? 0 : 1);
        result *= ((costPrice == null) ? 0 : 1);
        result *= ((sellingPrice == null) ? 0 : 1);
        result *= ((orders == null) ? 0 : 1);
        result *= ((lastOrder == null) ? 0 : 1);
        result *= ((categoryId == null) ? 0 : 1);
        result *= ((brandId == null) ? 0 : 1);
        result *= ((description == null) ? 0 : 1);
        result *= ((remainingQuantity == null) ? 0 : 1);

        return result > 0;
    }

    @Override
    public String toString() {
        return "ProductModel [description=" + description +
                ", features=" + features +
                ", costPrice=" + costPrice +
                ", sellingPrice=" + sellingPrice +
                ", orders=" + orders +
                ", lastOrder=" + lastOrder +
                ", remainingQuantity=" + remainingQuantity +
                ", creationDate=" + creationDate +
                ", enabled=" + enabled +
                ", adminId=" + adminId +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId + "]";
    }

}

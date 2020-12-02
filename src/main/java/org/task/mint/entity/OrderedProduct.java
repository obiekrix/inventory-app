package org.task.mint.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "_ordered_product")
@AssociationOverrides({ @AssociationOverride(name = "pk.product", joinColumns = @JoinColumn(name = "_product_id")),
		@AssociationOverride(name = "pk.order", joinColumns = @JoinColumn(name = "_order_id")) })
public class OrderedProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderedProductId pk = new OrderedProductId();

	@NotNull
	@Basic(optional = false)
	@Column(name = "_quantity")
	private Integer quantity;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_sold_price")
	private BigDecimal soldPrice;

	public OrderedProduct() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((soldPrice == null) ? 0 : soldPrice.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}
}

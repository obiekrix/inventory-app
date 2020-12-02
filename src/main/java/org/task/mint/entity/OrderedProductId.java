package org.task.mint.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Embeddable
public class OrderedProductId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Product product;

	@ManyToOne
	private Order order;

	public OrderedProductId() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

}

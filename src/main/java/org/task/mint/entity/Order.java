package org.task.mint.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Christian
 *
 */
@Getter
@Setter
@Entity
@Table(name = "_order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_time_of_sale")
	private Date timeOfSale;

	@ManyToOne(optional=false)
    @JoinColumn(name="_admin")
    private Admin admin;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pk.order")
	private Set<OrderedProduct> orderedProducts = new HashSet<OrderedProduct>(0);

	public Order() {
		
	}
	
	/**
	 * @param id
	 */
	public Order(Integer id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param timeOfSale
	 * @param admin
	 * @param orderedProducts
	 */
	public Order(Integer id, @NotNull Date timeOfSale, Admin admin, Set<OrderedProduct> orderedProducts) {
		this.id = id;
		this.timeOfSale = timeOfSale;
		this.admin = admin;
		this.orderedProducts = orderedProducts;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", timeOfSale=" + timeOfSale + ", admin=" + admin + ", orderedProducts="
				+ orderedProducts + "]";
	}

}

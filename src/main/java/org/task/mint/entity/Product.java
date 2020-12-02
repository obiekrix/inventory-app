package org.task.mint.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Christian
 */
@Getter
@Setter
@Entity
@Table(name = "_product")
public class Product implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_description")
	private String description;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_features")
	private String features;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_cost_price")
	private BigDecimal costPrice;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_selling_price")
	private BigDecimal sellingPrice;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_orders")
	private Integer orders;

	@Basic(optional = true)
	@Column(name = "_last_order")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastOrder;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_remaining_quantity")
	private Integer remainingQuantity;

	@Basic(optional = false)
	@Column(name = "_creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_enabled")
	private boolean enabled;

	@ManyToOne(optional=false)
    @JoinColumn(name="_admin_id")
    private Admin admin;

	@ManyToOne(optional = false)
	@JoinColumn(name = "_catagory_id")
	private Category category;

	@ManyToOne(optional = false)
	@JoinColumn(name = "_brand_id")
	private Brand brand;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pk.product")
	private Set<OrderedProduct> orderedProducts = new HashSet<OrderedProduct>(0);

	public Product() {

	}

	/**
	 * @param id
	 */
	public Product(@NotNull Integer id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param description
	 * @param features
	 * @param costPrice
	 * @param sellingPrice
	 * @param orders
	 * @param lastOrder
	 * @param remainingQuantity
	 * @param creationDate
	 * @param enabled
	 * @param admin
	 * @param category
	 * @param brand
	 */
	public Product(Integer id, @NotNull String description, @NotNull String features, @NotNull BigDecimal costPrice,
                   @NotNull BigDecimal sellingPrice, @NotNull Integer orders, Date lastOrder,
                   @NotNull Integer remainingQuantity, Date creationDate, @NotNull boolean enabled, Admin admin,
                   Category category, Brand brand) {
		this.id = id;
		this.description = description;
		this.features = features;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.orders = orders;
		this.lastOrder = lastOrder;
		this.remainingQuantity = remainingQuantity;
		this.creationDate = creationDate;
		this.enabled = enabled;
		this.admin = admin;
		this.category = category;
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", features=" + features + ", costPrice="
				+ costPrice + ", sellingPrice=" + sellingPrice + ", orders=" + orders + ", lastOrder=" + lastOrder
				+ ", remainingQuantity=" + remainingQuantity + ", creationDate=" + creationDate + ", enabled=" + enabled
				+ ", admin=" + admin + ", category=" + category + ", brand=" + brand + ", orderedProducts="
				+ orderedProducts + "]";
	}

}

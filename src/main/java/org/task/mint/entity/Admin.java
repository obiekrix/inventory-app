/**
 * 
 */
package org.task.mint.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Christian
 *
 */
@Getter
@Setter
@Entity
@Table(name = "_admin", uniqueConstraints = { @UniqueConstraint(columnNames = "_email") })
public class Admin implements Serializable {

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
	@Column(name = "_first_name")
	private String firstName;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_last_name")
	private String lastName;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_email", unique = true)
	private String email;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_password")
	private String password;

	@Basic(optional = false)
	@Column(name = "_creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@NotNull
	@Basic(optional = false)
	@Column(name = "_enabled")
	private boolean enabled;

	public Admin() {

	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param enabled
	 * @param enabled
	 */
	public Admin(@NotNull String firstName, @NotNull String lastName, @NotNull String email, @NotNull String password,
			@NotNull Date creationDate, @NotNull boolean enabled) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.enabled = enabled;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Admin)) {
			return false;
		}
		Admin other = (Admin) obj;
		if (creationDate == null) {
			if (other.creationDate != null) {
				return false;
			}
		} else if (!creationDate.equals(other.creationDate)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (enabled != other.enabled) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", creationDate=" + creationDate + ", enabled=" + enabled + "]";
	}

}

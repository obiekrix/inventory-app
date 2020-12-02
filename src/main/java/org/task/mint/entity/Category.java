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
@Table(name = "_category", uniqueConstraints = {@UniqueConstraint(columnNames = "_name")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "_name")
    private String name;

    @NotNull
    @Basic(optional = false)
    @Column(name = "_description")
    private String description;

    @Basic(optional = false)
    @Column(name = "_creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @NotNull
    @Basic(optional = false)
    @Column(name = "_enabled")
    private boolean enabled;

    @ManyToOne(optional = false)
    @JoinColumn(name = "_admin")
    private Admin admin;

    public Category() {

    }

    /**
     * @param id
     */
    public Category(Integer id) {
        this.id = id;
    }

    /**
     * @param id
     * @param name
     * @param description
     * @param creationDate
     * @param enabled
     * @param admin
     */
    public Category(Integer id, @NotNull String name, @NotNull String description, Date creationDate,
                    @NotNull boolean enabled, Admin admin) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.enabled = enabled;
        this.admin = admin;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category other = (Category) obj;
        if (admin == null) {
            if (other.admin != null) {
                return false;
            }
        } else if (!admin.equals(other.admin)) {
            return false;
        }
        if (creationDate == null) {
            if (other.creationDate != null) {
                return false;
            }
        } else if (!creationDate.equals(other.creationDate)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (enabled != other.enabled) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Category [id=" + id +
                ", name=" + name +
                ", description=" + description +
                ", creationDate=" + creationDate +
                ", enabled=" + enabled +
                ", admin=" + admin + "]";
    }

}

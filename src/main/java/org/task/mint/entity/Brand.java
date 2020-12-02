package org.task.mint.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "_brand", uniqueConstraints = {@UniqueConstraint(columnNames = "_name")})
public class Brand implements Serializable {

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
    @Column(name = "_name")
    private String name;

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

    public Brand() {

    }

    /**
     * @param id
     */
    public Brand(Integer id) {
        this.id = id;
    }

    /**
     * @param id
     * @param name
     * @param creationDate
     * @param enabled
     * @param admin
     */
    public Brand(@NotNull Integer id, @NotNull String name, Date creationDate, @NotNull boolean enabled, Admin admin) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.enabled = enabled;
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((admin == null) ? 0 : admin.hashCode());
        result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Brand)) {
            return false;
        }
        Brand other = (Brand) obj;
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
        return "Brand [id=" + id +
                ", name=" + name +
                ", creationDate=" + creationDate +
                ", enabled=" + enabled +
                ", admin=" + admin + "]";
    }

}

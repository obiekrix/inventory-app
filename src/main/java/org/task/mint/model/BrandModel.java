package org.task.mint.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class BrandModel {

    private String name;
    private Date creationDate;
    private Boolean enabled;
    private Integer adminId;

    public BrandModel() {

    }

    public boolean isInValidState() {
        Integer result = 1;

        result *= ((adminId == null) ? 0 : 1);
        result *= ((creationDate == null) ? 0 : 1);
        result *= ((enabled == null) ? 0 : 1);
        result *= ((name == null) ? 0 : 1);

        return result > 0;
    }

    @Override
    public String toString() {
        return "BrandModel [name=" + name +
                ", creationDate=" + creationDate +
                ", enabled=" + enabled +
                ", adminId=" + adminId + "]";
    }

}

package org.task.mint.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CategoryModel {

    private String name;
    private String description;
    private Date creationDate;
    private Boolean enabled;
    private Integer adminId;

    public CategoryModel() {

    }

    public boolean isInValidState() {
        Integer result = 1;

        result *= ((adminId == null) ? 0 : 1);
        result *= ((creationDate == null) ? 0 : 1);
        result *= ((enabled == null) ? 0 : 1);
        result *= ((name == null) ? 0 : 1);
        result *= ((description == null) ? 0 : 1);

        return result > 0;
    }

    @Override
    public String toString() {
        return "CategoryModel [name=" + name +
                ", description=" + description +
                ", creationDate=" + creationDate +
                ", enabled=" + enabled +
                ", adminId=" + adminId + "]";
    }

}

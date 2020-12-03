package org.task.mint.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String names;
    private String phoneNo;

    @Override
    public String toString() {
        return "Customer [names=" + names +
                ", phoneNo=" + phoneNo + "]";
    }
}

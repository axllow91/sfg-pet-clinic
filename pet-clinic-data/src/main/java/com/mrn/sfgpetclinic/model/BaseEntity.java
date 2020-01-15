package com.mrn.sfgpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private Long id; // boxed types can be null where primitive cannot

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

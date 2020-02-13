package com.mrn.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="types")
public class PetType extends BaseEntity {

    @JoinColumn(name="name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}

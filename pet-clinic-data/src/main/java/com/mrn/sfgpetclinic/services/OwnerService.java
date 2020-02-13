package com.mrn.sfgpetclinic.services;

import com.mrn.sfgpetclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
   /*
    this methods are already defined in the crud service interface that we created

    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
    */

}

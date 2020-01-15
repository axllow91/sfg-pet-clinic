package com.mrn.sfgpetclinic.services;

import com.mrn.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);

   /*
    this methods are already defined in the crud service interface that we created

    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
    */

}

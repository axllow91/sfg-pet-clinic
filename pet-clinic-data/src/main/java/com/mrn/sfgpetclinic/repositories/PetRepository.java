package com.mrn.sfgpetclinic.repositories;

import com.mrn.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

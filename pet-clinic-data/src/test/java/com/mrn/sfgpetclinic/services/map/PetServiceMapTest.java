package com.mrn.sfgpetclinic.services.map;

import com.mrn.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PetServiceMapTest {

    PetServiceMap petServiceMap;
    private final Long petId = 1L;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        petServiceMap.save(Pet.builder().id(petId).build());
    }

    @Test
    void findAll() {
        Set<Pet> pets = petServiceMap.findAll();

        assertEquals(1, pets.size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Pet pet2 = Pet.builder().id(id).build();
        Pet savedPet = petServiceMap.save(pet2);

        assertEquals(id, savedPet.getId());
    }

    @Test
    void saveDuplicateId() {
        Long id = 1L;
        Pet pet2 = Pet.builder().id(id).build();
        Pet saved = petServiceMap.save(pet2);

        assertEquals(id, saved.getId());
    }

    @Test
    void saveWithoutId() {
        Pet pet = petServiceMap.save(Pet.builder().build());

        assertNotNull(pet);
        assertNotNull(pet.getId());
        assertEquals(2, petServiceMap.findAll().size()); // compare size
    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(petId));
        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void deleteWithNullId() {
        Pet pet = Pet.builder().build();
        petServiceMap.deleteById(pet.getId());

        assertEquals(1, petServiceMap.findAll().size());

    }

    @Test
    void deleteByWithCorrectId() {
        petServiceMap.deleteById(petId);
        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void deleteByIncorrectId() {
        petServiceMap.deleteById(5L);
        assertEquals(1, petServiceMap.findAll().size());
    }


    @Test
    void deleteByNullId() {
        petServiceMap.deleteById(null);
        assertEquals(1, petServiceMap.findAll().size());
    }

    @Test
    void findByExistingId() {
        Pet pet = petServiceMap.findById(petId);

        assertEquals(petId, pet.getId());
    }


    @Test
    void findByNotExistingId() {
        Pet pet = petServiceMap.findById(5L); // try to find an non existing pet

        assertNull(pet);
    }

    @Test
    void findByNullId() {
        Pet pet = petServiceMap.findById(null); // try to find an non existing pet

        assertNull(pet);
    }
}
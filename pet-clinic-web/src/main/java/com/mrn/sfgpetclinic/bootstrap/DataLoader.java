package com.mrn.sfgpetclinic.bootstrap;

import com.mrn.sfgpetclinic.model.Owner;
import com.mrn.sfgpetclinic.model.Pet;
import com.mrn.sfgpetclinic.model.PetType;
import com.mrn.sfgpetclinic.model.Vet;
import com.mrn.sfgpetclinic.services.OwnerService;
import com.mrn.sfgpetclinic.services.PetTypeService;
import com.mrn.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

// becomes a spring bean and is loaded in the spring context where the spring context after gets up and running will run the run the context method and will
// run
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Doggo");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Catty");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Some Street");
        owner1.setCity("Miami");
        owner1.setTelephone("9999999");

        Pet mikePet = new Pet();
        mikePet.setPetType(savedDogPetType);
        mikePet.setOwner(owner1);
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setName("Rosco");

        owner1.getPets().add(mikePet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner1.setAddress("111 Darvai");
        owner1.setCity("Moscow");
        owner1.setTelephone("1111111");

        Pet fionaPet = new Pet();
        mikePet.setPetType(savedCatPetType);
        mikePet.setOwner(owner2);
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setName("Petisca");

        owner2.getPets().add(fionaPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ariba");
        vet2.setLastName("Kuman");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}

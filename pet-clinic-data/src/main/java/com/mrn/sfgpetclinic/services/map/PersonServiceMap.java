package com.mrn.sfgpetclinic.services.map;

import com.mrn.sfgpetclinic.model.Person;
import com.mrn.sfgpetclinic.services.CrudService;

import java.util.Set;

public class PersonServiceMap extends AbstractMapService<Person, Long> implements CrudService<Person, Long> {
    @Override
    public Set<Person> findAll() {
        return super.findAll();
    }

    @Override
    public Person save(Person object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Person object) {
        super.deleteByObject(object);
    }


    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Person findById(Long id) {
        return super.findById(id);
    }
}

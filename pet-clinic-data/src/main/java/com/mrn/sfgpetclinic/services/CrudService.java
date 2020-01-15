package com.mrn.sfgpetclinic.services;

import java.util.Set;

/*
* This interface is mimicking the crud repository from spring data
* */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}

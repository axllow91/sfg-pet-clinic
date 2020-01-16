package com.mrn.sfgpetclinic.services.map;

import com.mrn.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) { // if my object is not equal to null
            if (object.getId() == null) { // try to get the id but is null set the id to be the next id (ex: 0L + 1 = 1L)
                object.setId(getNextId()); // set the next id
            }
            // put the object in the map
            map.put(object.getId(), object);
        } else {
            // if object is null
            throw new RuntimeException("Object cannot be null!");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void deleteByObject(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}

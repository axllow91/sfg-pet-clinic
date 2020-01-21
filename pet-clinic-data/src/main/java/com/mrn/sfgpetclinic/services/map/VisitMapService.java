package com.mrn.sfgpetclinic.services.map;

import com.mrn.sfgpetclinic.model.Visit;
import com.mrn.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

// Visit map service
@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.deleteByObject(object);
    }

    @Override
    public Visit save(Visit visit) {
        // check if the visit is valid (has a pet and an owner)
        if(visit.getPet() == null || visit.getPet().getId() == null
                || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}

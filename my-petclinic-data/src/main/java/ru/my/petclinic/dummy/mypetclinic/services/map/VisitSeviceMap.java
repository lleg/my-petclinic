package ru.my.petclinic.dummy.mypetclinic.services.map;

import ru.my.petclinic.dummy.mypetclinic.model.Visits;
import ru.my.petclinic.dummy.mypetclinic.services.VisitService;

import java.util.Set;

public class VisitSeviceMap extends AbstractMapService<Visits, Long> implements VisitService {
    @Override
    public Set<Visits> findAll() {
        return super.findAll();
    }

    @Override
    public Visits findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visits save(Visits visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null ||
                visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid visit");
        }
        return super.save(visit);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Visits object) {
        super.delete(object);
    }
}

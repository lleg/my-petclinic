package ru.my.petclinic.dummy.mypetclinic.services.map;

import org.springframework.stereotype.Service;
import ru.my.petclinic.dummy.mypetclinic.model.Visit;
import ru.my.petclinic.dummy.mypetclinic.services.VisitService;

import java.util.Set;
@Service
public class VisitSeviceMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit visit) {
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
    public void delete(Visit object) {
        super.delete(object);
    }
}

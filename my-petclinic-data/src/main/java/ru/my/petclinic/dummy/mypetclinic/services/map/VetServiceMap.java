package ru.my.petclinic.dummy.mypetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.my.petclinic.dummy.mypetclinic.model.Speciality;
import ru.my.petclinic.dummy.mypetclinic.model.Vet;
import ru.my.petclinic.dummy.mypetclinic.services.SpecialityService;
import ru.my.petclinic.dummy.mypetclinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Vet save(Vet object) {

        if(object != null) {
            if (object.getSpeciality().size() > 0) {
                object.getSpeciality().stream().filter(speciality -> speciality.getId() == null).forEach(speciality -> {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                });
            }

        }

        return super.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}

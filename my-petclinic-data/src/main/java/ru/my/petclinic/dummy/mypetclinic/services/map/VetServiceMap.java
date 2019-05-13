package ru.my.petclinic.dummy.mypetclinic.services.map;

import ru.my.petclinic.dummy.mypetclinic.model.Vet;
import ru.my.petclinic.dummy.mypetclinic.services.CrudService;
import ru.my.petclinic.dummy.mypetclinic.services.VetService;
import ru.my.petclinic.dummy.mypetclinic.services.map.BaseMapService;

import java.util.Set;

public class VetServiceMap extends BaseMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Vet save(Long aLong, Vet object) {
        return super.save(aLong, object);
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

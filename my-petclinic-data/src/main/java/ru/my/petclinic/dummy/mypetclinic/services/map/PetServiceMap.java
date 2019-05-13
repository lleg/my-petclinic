package ru.my.petclinic.dummy.mypetclinic.services.map;

import ru.my.petclinic.dummy.mypetclinic.model.Pet;
import ru.my.petclinic.dummy.mypetclinic.services.CrudService;
import ru.my.petclinic.dummy.mypetclinic.services.PetService;
import ru.my.petclinic.dummy.mypetclinic.services.map.BaseMapService;

import java.util.Set;

public class PetServiceMap extends BaseMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Pet save(Long aLong, Pet object) {
        return super.save(aLong, object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }
}



package ru.my.petclinic.dummy.mypetclinic.services.map;

import ru.my.petclinic.dummy.mypetclinic.model.Owner;
import ru.my.petclinic.dummy.mypetclinic.services.CrudService;
import ru.my.petclinic.dummy.mypetclinic.services.OwnerService;
import ru.my.petclinic.dummy.mypetclinic.services.map.BaseMapService;

import java.util.Set;

public class OwnerServiceMap extends BaseMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Owner save(Long aLong, Owner object) {
        return super.save(aLong, object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}

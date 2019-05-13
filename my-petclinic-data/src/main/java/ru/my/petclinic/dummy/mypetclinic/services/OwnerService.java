package ru.my.petclinic.dummy.mypetclinic.services;

import ru.my.petclinic.dummy.mypetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}

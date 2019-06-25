package ru.my.petclinic.dummy.mypetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.my.petclinic.dummy.mypetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

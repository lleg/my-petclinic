package ru.my.petclinic.dummy.mypetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.my.petclinic.dummy.mypetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

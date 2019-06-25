package ru.my.petclinic.dummy.mypetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.my.petclinic.dummy.mypetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

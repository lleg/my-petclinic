package ru.my.petclinic.dummy.mypetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.my.petclinic.dummy.mypetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}

package ru.my.petclinic.dummy.mypetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.my.petclinic.dummy.mypetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}

package ru.my.petclinic.dummy.mypetclinic.repository;

import org.springframework.data.repository.CrudRepository;
import ru.my.petclinic.dummy.mypetclinic.model.Visits;

public interface VisitRepository extends CrudRepository<Visits, Long> {
}

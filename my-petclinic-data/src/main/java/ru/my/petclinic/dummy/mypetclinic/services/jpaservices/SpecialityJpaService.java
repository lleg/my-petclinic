package ru.my.petclinic.dummy.mypetclinic.services.jpaservices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.my.petclinic.dummy.mypetclinic.model.Speciality;
import ru.my.petclinic.dummy.mypetclinic.repository.SpecialityRepository;
import ru.my.petclinic.dummy.mypetclinic.services.SpecialityService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpaservices")
public class SpecialityJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specs = new HashSet<>();
        specialityRepository.findAll().forEach(specs::add);
        return specs;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}

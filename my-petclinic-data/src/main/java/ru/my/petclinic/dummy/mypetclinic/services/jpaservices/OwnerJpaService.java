package ru.my.petclinic.dummy.mypetclinic.services.jpaservices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.my.petclinic.dummy.mypetclinic.model.Owner;
import ru.my.petclinic.dummy.mypetclinic.repository.OwnerRepository;
import ru.my.petclinic.dummy.mypetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpaservices")
public class OwnerJpaService implements OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}

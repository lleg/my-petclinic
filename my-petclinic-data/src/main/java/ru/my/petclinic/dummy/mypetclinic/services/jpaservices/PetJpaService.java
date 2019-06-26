package ru.my.petclinic.dummy.mypetclinic.services.jpaservices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.my.petclinic.dummy.mypetclinic.model.Pet;
import ru.my.petclinic.dummy.mypetclinic.repository.PetRepository;
import ru.my.petclinic.dummy.mypetclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpaservices")
public class PetJpaService implements PetService {

    private final PetRepository petRepository;

    public PetJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}

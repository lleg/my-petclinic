package ru.my.petclinic.dummy.mypetclinic.services.map;

import org.springframework.stereotype.Service;
import ru.my.petclinic.dummy.mypetclinic.model.Owner;
import ru.my.petclinic.dummy.mypetclinic.model.Pet;
import ru.my.petclinic.dummy.mypetclinic.services.OwnerService;
import ru.my.petclinic.dummy.mypetclinic.services.PetService;
import ru.my.petclinic.dummy.mypetclinic.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else {
                        throw new RuntimeException("Pet type is needed");
                    }
                    if(pet.getId() == null){
                        Pet newPet = petService.save(pet);
                        pet.setId(newPet.getId());
                    }

                });
            }
            return super.save(object);
        }
        else{
            return null;
        }

    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}

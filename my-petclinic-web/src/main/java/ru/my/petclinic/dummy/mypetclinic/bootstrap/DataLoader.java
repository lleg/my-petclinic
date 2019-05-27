package ru.my.petclinic.dummy.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.my.petclinic.dummy.mypetclinic.model.Owner;
import ru.my.petclinic.dummy.mypetclinic.model.Pet;
import ru.my.petclinic.dummy.mypetclinic.model.PetType;
import ru.my.petclinic.dummy.mypetclinic.model.Vet;
import ru.my.petclinic.dummy.mypetclinic.services.map.OwnerServiceMap;
import ru.my.petclinic.dummy.mypetclinic.services.map.PetTypesServiceMap;
import ru.my.petclinic.dummy.mypetclinic.services.map.VetServiceMap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerServiceMap;
    private final VetServiceMap vetServiceMap;
    private final PetTypesServiceMap petTypesServiceMap;


    public DataLoader(OwnerServiceMap ownerServiceMap, VetServiceMap vetServiceMap, PetTypesServiceMap petTypesServiceMap) {

        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
        this.petTypesServiceMap = petTypesServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType catSaved = petTypesServiceMap.save(cat);
        PetType dogSaved = petTypesServiceMap.save(dog);

        System.out.println("@@@@@@@@@@ PetTypes loaded");

        Owner owner1  = new Owner();
        owner1.setFirstName("Ivan");
        owner1.setLastName("Petrov");
        owner1.setAddress("Russia, Zhuk street");
        owner1.setCity("Moscow");
        owner1.setPhone("12345");

        Pet owner1Pet = new Pet();
        owner1Pet.setName("Murz");
        owner1Pet.setPetType(catSaved);
        owner1Pet.setBirthDate(LocalDate.now());
        owner1Pet.setOwner(owner1);

        owner1.getPets().add(owner1Pet);

        Owner owner2  = new Owner();
        owner2.setFirstName("Petr");
        owner2.setLastName("Volkov");
        owner2.setAddress("India, Kali street");
        owner2.setCity("Delhi");
        owner2.setPhone("3333333");

        Pet owner2Pet = new Pet();
        owner2Pet.setName("Sharic");
        owner2Pet.setPetType(dogSaved);
        owner2Pet.setBirthDate(LocalDate.now());
        owner2Pet.setOwner(owner2);

        owner1.getPets().add(owner2Pet);

        ownerServiceMap.save(owner1);
        ownerServiceMap.save(owner2);

        System.out.println("@@@@@@@@@@ Owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Elsa");
        vet1.setLastName("Krop");

        Vet vet2 = new Vet();
        vet2.setFirstName("Karl");
        vet2.setLastName("Krop");

        vetServiceMap.save(vet1);
        vetServiceMap.save(vet2);

        System.out.println("@@@@@@@@@@ Vets loaded");




    }
}

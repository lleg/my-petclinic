package ru.my.petclinic.dummy.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.my.petclinic.dummy.mypetclinic.model.Owner;
import ru.my.petclinic.dummy.mypetclinic.model.PetType;
import ru.my.petclinic.dummy.mypetclinic.model.Vet;
import ru.my.petclinic.dummy.mypetclinic.services.map.OwnerServiceMap;
import ru.my.petclinic.dummy.mypetclinic.services.map.PetTypesServiceMap;
import ru.my.petclinic.dummy.mypetclinic.services.map.VetServiceMap;


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

        Owner owner1  = new Owner();
        owner1.setFirstName("Ivan");
        owner1.setLastName("Petrov");

        Owner owner2  = new Owner();
        owner2.setFirstName("Petr");
        owner2.setLastName("Volkov");

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

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType dog = new PetType();
        dog.setName("Dog");

        petTypesServiceMap.save(cat);
        petTypesServiceMap.save(dog);

        System.out.println("@@@@@@@@@@ PetTypes loaded");


    }
}

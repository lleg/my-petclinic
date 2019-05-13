package ru.my.petclinic.dummy.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.my.petclinic.dummy.mypetclinic.model.Owner;
import ru.my.petclinic.dummy.mypetclinic.model.Vet;
import ru.my.petclinic.dummy.mypetclinic.services.map.OwnerServiceMap;
import ru.my.petclinic.dummy.mypetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerServiceMap;
    private final VetServiceMap vetServiceMap;


    public DataLoader(OwnerServiceMap ownerServiceMap, VetServiceMap vetServiceMap) {

        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1  = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Ivan");
        owner1.setLastName("Petrov");

        Owner owner2  = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Petr");
        owner2.setLastName("Volkov");

        ownerServiceMap.save(1L, owner1);
        ownerServiceMap.save(2L, owner2);

        System.out.println("@@@@@@@@@@ Owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Elsa");
        vet1.setLastName("Krop");
        vet1.setId(1L);

        Vet vet2 = new Vet();
        vet2.setFirstName("Karl");
        vet2.setLastName("Krop");
        vet2.setId(2L);

        vetServiceMap.save(1L, vet1);
        vetServiceMap.save(2L, vet2);

        System.out.println("@@@@@@@@@@ Vets loaded");

    }
}

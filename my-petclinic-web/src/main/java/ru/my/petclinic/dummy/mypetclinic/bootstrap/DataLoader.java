package ru.my.petclinic.dummy.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.my.petclinic.dummy.mypetclinic.model.*;
import ru.my.petclinic.dummy.mypetclinic.services.map.*;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerServiceMap;
    private final VetServiceMap vetServiceMap;
    private final PetTypesServiceMap petTypesServiceMap;
    private final SpecialityServiceMap specialityServiceMap;
    private final VisitSeviceMap visitSeviceMap;


    public DataLoader(OwnerServiceMap ownerServiceMap, VetServiceMap vetServiceMap, PetTypesServiceMap petTypesServiceMap, SpecialityServiceMap specialityServiceMap, VisitSeviceMap visitSeviceMap) {

        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
        this.petTypesServiceMap = petTypesServiceMap;
        this.specialityServiceMap = specialityServiceMap;
        this.visitSeviceMap = visitSeviceMap;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypesServiceMap.findAll().size() == 0){
            setData();
        }


    }

    private void setData() {
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

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        specialityServiceMap.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        specialityServiceMap.save(surgery);

        Speciality dentictry = new Speciality();
        dentictry.setDescription("Dentictry");
        specialityServiceMap.save(dentictry);

        System.out.println("@@@@@@@@@@ Specialities loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Elsa");
        vet1.setLastName("Krop");
        vet1.getSpeciality().add(dentictry);

        Vet vet2 = new Vet();
        vet2.setFirstName("Karl");
        vet2.setLastName("Krop");
        vet2.getSpeciality().add(radiology);

        vetServiceMap.save(vet1);
        vetServiceMap.save(vet2);

        System.out.println("@@@@@@@@@@ Vets loaded");

        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Dog");
        visit1.setPet(owner1Pet);

        Visit visit2 = new Visit();
        visit2.setDate(LocalDate.now());
        visit2.setDescription("Cat");
        visit2.setPet(owner2Pet);

        visitSeviceMap.save(visit1);
        visitSeviceMap.save(visit2);

        System.out.println("@@@@@@@@@@ Visits loaded");
    }
}

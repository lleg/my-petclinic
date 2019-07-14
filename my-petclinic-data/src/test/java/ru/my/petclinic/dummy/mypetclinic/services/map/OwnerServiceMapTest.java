package ru.my.petclinic.dummy.mypetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.my.petclinic.dummy.mypetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    private final Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypesServiceMap(), new PetServiceMap());
        Owner owner = ownerServiceMap.save(new Owner(ownerId, "Ivan", "Ivanos"));
    }

    @Test
    void findAll() {
        Set<Owner> all = ownerServiceMap.findAll();
        assertEquals(1, all.size());
    }

    @Test
    void findById() {
        Owner ownerById = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, ownerById.getId());
    }

    @Test
    void save() {
        Owner owner = ownerServiceMap.save(new Owner(ownerId, "Ivan", "Ivanos"));
        Owner owner1 = ownerServiceMap.save(owner);
        assertEquals(owner1.getId(), owner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = ownerServiceMap.save(Owner.builder().build());

        assertNotNull(owner);
        assertNotNull(owner.getId());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName("Ivanos");
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());

    }
}
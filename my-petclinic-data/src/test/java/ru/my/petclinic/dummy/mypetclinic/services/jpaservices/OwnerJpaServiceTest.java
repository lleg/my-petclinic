package ru.my.petclinic.dummy.mypetclinic.services.jpaservices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.my.petclinic.dummy.mypetclinic.model.Owner;
import ru.my.petclinic.dummy.mypetclinic.repository.OwnerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    long ownerId = 1L;
    String ivan1 = "Ivan";
    String lastName = "Ivanos";
    Owner retOwner;

    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerJpaService ownerJpaService;

    @BeforeEach
    void setUp() {
        retOwner = new Owner(ownerId, ivan1, lastName);
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(retOwner);
        Owner ivanov = ownerJpaService.findByLastName(lastName);
        assertEquals(lastName, ivanov.getLastName());

    }

    @Test
    void findAll() {

        Set<Owner> owners = new HashSet<>();
        owners.add(retOwner);
        owners.add(new Owner(2L, ivan1, lastName));

        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> allOwners = ownerJpaService.findAll();

        assertNotNull(allOwners);
        assertEquals(2, allOwners.size());

    }

    @Test
    void findByIdNotNull() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerJpaService.findById(1L);

        assertNull(owner);

    }


    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
        ownerJpaService.delete(retOwner);

        verify(ownerRepository).delete(retOwner);

    }

    @Test
    void deleteById() {
    }
}
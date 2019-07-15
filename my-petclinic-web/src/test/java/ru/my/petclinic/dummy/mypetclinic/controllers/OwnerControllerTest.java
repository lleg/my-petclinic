package ru.my.petclinic.dummy.mypetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.my.petclinic.dummy.mypetclinic.model.Owner;
import ru.my.petclinic.dummy.mypetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    String ivan1 = "Ivan";
    String lastName = "Ivanos";

    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(new Owner(1L, ivan1, lastName));
        owners.add(new Owner(2L, ivan1, lastName));

        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void index() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners")).andExpect(status().is(200))
                .andExpect(view().name("/owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));

    }

    @Test
    void indexOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners/index.html")).andExpect(status().is(200))
                .andExpect(view().name("/owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));

    }

    @Test
    void findOwners() throws Exception {

        mockMvc.perform(get("/owners/find")).andExpect(status().is(200))
                .andExpect(view().name("/notimplemented"));
    }
}
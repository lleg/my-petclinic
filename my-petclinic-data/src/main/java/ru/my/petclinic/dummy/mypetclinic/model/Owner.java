package ru.my.petclinic.dummy.mypetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "owner")
public class Owner extends Person {


    public Owner(Long id, String firstName, String lastName, String address, String city, String phone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.pets = pets;
    }

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "phone")
    private String phone;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet();


    public Owner(long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}

package com.livestream.rhastalive.model;

import com.livestream.rhastalive.model.users.Artist;
import com.livestream.rhastalive.model.users.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address extends GenericModel {

    @Column(name = "address")
    private String address;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Artist artist;
}

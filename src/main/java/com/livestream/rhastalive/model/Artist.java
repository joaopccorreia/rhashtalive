package com.livestream.rhastalive.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "artist")
public class Artist extends GenericModel{

    private String firstName;
    private String lastName;
    private String artisticName;
    private String vatNumber;
    private String email;
    private String password;
    private Integer phone;
    private Integer address_id;
}

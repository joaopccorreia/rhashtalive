package com.livestream.rhastalive.model.users;

import com.livestream.rhastalive.model.Address;
import com.livestream.rhastalive.model.GenericModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "artist")
public class Artist extends GenericModel {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "artisticName")
    private String artisticName;

    @Column(name = "vatNumber")
    private String vatNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "artist"
    )
    @Column(name = "address")
    private List<Address> address = new ArrayList<>();

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "artist",
            fetch = FetchType.LAZY
    )
    private User user;

}

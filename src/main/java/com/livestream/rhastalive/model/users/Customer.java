package com.livestream.rhastalive.model.users;


import com.livestream.rhastalive.model.Address;
import com.livestream.rhastalive.model.GenericModel;
import com.livestream.rhastalive.model.Product;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer extends GenericModel {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "vatNumber")
    private String vatNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "customer"
    )
    @Column(name = "address")
    private List<Address> address = new ArrayList<>();

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "customer",
            fetch = FetchType.LAZY
    )
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "customer_product",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> listOfBoughtProducts;


    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + user.getPassword() + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

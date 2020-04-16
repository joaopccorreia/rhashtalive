package com.livestream.rhastalive.model;

import com.livestream.rhastalive.model.users.Customer;
import com.livestream.rhastalive.model.users.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends GenericModel {

    @Column(name = "name")
    private String name;

    @Column(name = "availableQuantity")
    private Integer availableQuantity;

    @Column(name = "availableDate")
    private Date availableDate;

    @Column(name = "productType")
    private String productType;

    @Column(name = "isActive")
    private Boolean active;

    @OneToOne
    private Show show;
}

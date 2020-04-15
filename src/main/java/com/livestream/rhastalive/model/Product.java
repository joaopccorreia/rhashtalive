package com.livestream.rhastalive.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

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
}

package com.livestream.rhastalive.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "shows")
public class Show extends GenericModel {

    private String name;
    private Date date;
    private Integer durationTime;
    private Integer capacityLimit;
    private String description;
    private boolean highlight;
    private String thumbnail;

    @OneToOne
    private Product product;
}

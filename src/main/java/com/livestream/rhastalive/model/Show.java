package com.livestream.rhastalive.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private String showLink;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "show",
            fetch = FetchType.LAZY
    )
    private Product product;
}

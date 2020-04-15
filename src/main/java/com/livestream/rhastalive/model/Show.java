package com.livestream.rhastalive.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "shows")
public class Show extends GenericModel {

    private String name;
    private Date date;
    private Time durationime;
    private Integer capacityLimit;
}

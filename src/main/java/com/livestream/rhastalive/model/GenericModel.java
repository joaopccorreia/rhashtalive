package com.livestream.rhastalive.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class GenericModel implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @CreationTimestamp
    @Column(name = "creationTime")
    private Timestamp creationTime;

    @UpdateTimestamp
    @Column(name = "updateTime")
    private Timestamp updateTime;

    @Version
    @Column(name = "version")
    private Integer version;

    public Integer getId() {
        return id;
    }
}

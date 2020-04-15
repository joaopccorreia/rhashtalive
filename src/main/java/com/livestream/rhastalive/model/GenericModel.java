package com.livestream.rhastalive.model;

<<<<<<< HEAD
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
=======
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
>>>>>>> d3fe171f7784731b6b9f7a8f2dfed60c9cf7911d

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
}

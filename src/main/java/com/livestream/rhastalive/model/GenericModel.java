package com.livestream.rhastalive.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public abstract class GenericModel {

    private Integer id;
    private Date creationTime;
    private Date updateTime;
    private Integer version;
}

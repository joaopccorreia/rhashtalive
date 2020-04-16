package com.livestream.rhastalive.model.users;

import com.livestream.rhastalive.model.GenericModel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role extends GenericModel {

    private String name;

    public String getName() {
        return name;
    }
}

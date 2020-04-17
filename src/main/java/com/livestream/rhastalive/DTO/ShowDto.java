package com.livestream.rhastalive.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter @Setter
@Component
public class ShowDto {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Date date;

    @NotNull
    private Integer durationTime;

    @NotNull
    private Integer capacityLimit;

    @NotNull
    private String description;

    private String thumbnail;

    private String showLink;


}

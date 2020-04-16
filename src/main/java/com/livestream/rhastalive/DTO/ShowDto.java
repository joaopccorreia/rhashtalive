package com.livestream.rhastalive.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Getter @Setter
@Component
public class ShowsDto {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Date date;

    @NotNull
    private Time durationTime;

    @NotNull
    private Integer capacityLimit;

}

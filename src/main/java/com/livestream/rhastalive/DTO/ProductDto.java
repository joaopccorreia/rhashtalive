package com.livestream.rhastalive.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.sql.Time;

@Getter
@Setter
@Component
public class ProductDto {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Integer availableQuantity;
    @NotNull
    private Time availableDate;
    @NotNull
    private String productType;



}

package com.livestream.rhastalive.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Getter @Setter
@Component
public class UserDto {

    private Integer customerId;

    private Integer artistId;

    private String userName;

    @NotNull
    private String password;

    @NotNull
    private Boolean active;

}

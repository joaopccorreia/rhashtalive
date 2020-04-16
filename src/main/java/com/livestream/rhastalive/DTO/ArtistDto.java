package com.livestream.rhastalive.DTO;

import com.livestream.rhastalive.model.Address;
import com.livestream.rhastalive.model.users.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
@Component
public class ArtistDto {

    @NotNull
    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String artisticName;

    @NotNull
    private String vatNumber;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private List<Address> addressList;

    private User user;
}

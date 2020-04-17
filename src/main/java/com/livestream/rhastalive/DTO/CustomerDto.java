package com.livestream.rhastalive.DTO;

import com.livestream.rhastalive.model.Product;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Getter @Setter
@Component
public class CustomerDto  {

    @NotNull
    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String vatNumber;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    private List<Product> listOfBoughtProducts;

    public List<Product> getListOfBoughtProducts() {
        return listOfBoughtProducts;
    }
}

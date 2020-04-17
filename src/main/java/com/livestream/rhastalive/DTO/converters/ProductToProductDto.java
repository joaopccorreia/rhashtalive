package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.ProductDto;
import com.livestream.rhastalive.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDto extends AbstractConverters<Product, ProductDto> {

    @Override
    public ProductDto convert(Product product) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(product, ProductDto.class);
    }
}

package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.ProductDto;
import com.livestream.rhastalive.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoToProduct extends AbstractConverters<ProductDto, Product> {

    @Override
    public Product convert(ProductDto productDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(productDto, Product.class);
    }
}

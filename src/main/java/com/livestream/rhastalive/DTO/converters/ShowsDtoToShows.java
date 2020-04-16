package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.ShowDto;
import com.livestream.rhastalive.model.Show;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ShowsDtoToShows extends AbstractConverters<ShowDto, Show> {

    @Override
    public Show convert(ShowDto showDto) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(showDto, Show.class);

    }
}

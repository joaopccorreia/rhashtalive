package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.ShowsDto;
import com.livestream.rhastalive.model.Show;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ShowsDtoToShows extends AbstractConverters<ShowsDto, Show> {

    @Override
    public Show convert(ShowsDto showsDto) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(showsDto, Show.class);

    }
}

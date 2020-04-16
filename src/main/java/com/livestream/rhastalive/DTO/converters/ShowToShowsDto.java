package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.ShowDto;
import com.livestream.rhastalive.model.Show;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ShowToShowsDto extends AbstractConverters<Show, ShowDto> {

    @Override
    public ShowDto convert(Show show) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(show, ShowDto.class);

    }
}

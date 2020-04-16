package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.ShowsDto;
import com.livestream.rhastalive.model.Show;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ShowsToShowsDto extends AbstractConverters<Show, ShowsDto> {

    @Override
    public ShowsDto convert(Show show) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(show, ShowsDto.class);

    }
}

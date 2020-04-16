package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.ArtistDto;
import com.livestream.rhastalive.model.users.Artist;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ArtistDtoToArtits extends AbstractConverters<ArtistDto, Artist> {

    @Override
    public Artist convert(ArtistDto artistDto) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(artistDto, Artist.class);

    }
}

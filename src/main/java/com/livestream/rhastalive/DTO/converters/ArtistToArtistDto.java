package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.ArtistDto;
import com.livestream.rhastalive.model.users.Artist;
import org.modelmapper.ModelMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ArtistToArtistDto extends AbstractConverters<Artist, ArtistDto> {

    @Override
    public ArtistDto convert(@NonNull Artist artist) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(artist, ArtistDto.class);

    }
}

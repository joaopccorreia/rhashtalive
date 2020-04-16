package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.UserDto;
import com.livestream.rhastalive.model.users.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto extends AbstractConverters<User, UserDto>{

    @Override
    public UserDto convert(User user) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDto.class);

    }
}

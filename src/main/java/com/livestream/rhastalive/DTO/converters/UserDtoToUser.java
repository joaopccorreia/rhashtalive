package com.livestream.rhastalive.DTO.converters;

import com.livestream.rhastalive.DTO.UserDto;
import com.livestream.rhastalive.model.users.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser extends AbstractConverters<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDto, User.class);
    }
}

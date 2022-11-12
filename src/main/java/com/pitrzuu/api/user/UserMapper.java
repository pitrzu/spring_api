package com.pitrzuu.api.user;

import com.pitrzuu.api.user.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper{
    public User createEntity( UserDto dto ){
        return new User()
                .setHash(dto.getHash())
                .setSalt(dto.getSalt());
    }
}

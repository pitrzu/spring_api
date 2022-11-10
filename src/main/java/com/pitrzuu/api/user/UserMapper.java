package com.pitrzuu.api.user;

import com.pitrzuu.api.user.dto.UserDto;

public class UserMapper{
    public static User createEntity( UserDto dto ){
        return new User()
                .setHash(dto.getHash())
                .setSalt(dto.getSalt());
    }
}

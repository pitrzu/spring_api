package com.pitrzuu.api.user.dto;

import java.util.Objects;

public class UserDto{
    private String hash;
    private String salt;

    public String getHash(){
        return hash;
    }
    public String getSalt(){
        return salt;
    }

    public UserDto setHash( String hash ){
        this.hash = hash;
        return this;
    }
    public UserDto setSalt( String salt ){
        this.salt = salt;
        return this;
    }

    @Override
    public boolean equals( Object o ){
        if(this == o) return true;
        if(!( o instanceof UserDto userDto )) return false;
        return getHash().equals(userDto.getHash()) && getSalt().equals(userDto.getSalt());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getHash(), getSalt());
    }
}

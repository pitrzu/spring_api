package com.pitrzuu.api.location;

import com.pitrzuu.api.location.dto.CreateLocationDto;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper{
    public static Location createEntity( CreateLocationDto location ){
        return new Location()
                .setCity(location.getCity())
                .setPostCode(location.getPostCode())
                .setStreet(location.getStreet())
                .setStreetNumber(location.getStreetNumber());
    }
}

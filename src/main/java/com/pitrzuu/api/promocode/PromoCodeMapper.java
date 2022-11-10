package com.pitrzuu.api.promocode;

import org.springframework.stereotype.Component;

@Component
public class PromoCodeMapper{
    public GetPromoCodeDto createDto( PromoCode promoCode ){
        return new GetPromoCodeDto()
                .setPromoCode(promoCode.getName())
                .setAmount(promoCode.getDiscountAmount())
                .setPercentage(promoCode.getDiscountPercentage())
                .setExpirationDate(promoCode.getEndTime());
    }
}

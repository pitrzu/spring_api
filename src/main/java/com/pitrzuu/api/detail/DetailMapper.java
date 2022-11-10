package com.pitrzuu.api.detail;

import com.pitrzuu.api.category.Category;
import com.pitrzuu.api.detail.dto.CreateDetailDto;
import com.pitrzuu.api.detail.dto.GetDetailDto;
import com.pitrzuu.api.item.IItemRepository;
import com.pitrzuu.api.item.Item;
import com.pitrzuu.api.pricing.IPricedItemRepository;
import com.pitrzuu.api.pricing.PriceID;
import com.pitrzuu.api.pricing.PriceMapper;
import com.pitrzuu.api.pricing.PricedItem;
import com.pitrzuu.api.promocode.IPromoCodeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DetailMapper{
    public DetailMapper( IPricedItemRepository pricedItemsRepository,
                         IItemRepository itemsRepository,
                         IPromoCodeRepository promoCodesRepository ){
        this.pricedItemsRepository = pricedItemsRepository;
        this.itemsRepository = itemsRepository;
        this.promoCodesRepository = promoCodesRepository;
    }

    private final IPricedItemRepository pricedItemsRepository;
    private final IItemRepository itemsRepository;
    private final IPromoCodeRepository promoCodesRepository;

    public OrderDetail createEntity( CreateDetailDto dto){
        PricedItem pricedItem = pricedItemsRepository.findById(new PriceID(
                itemsRepository.findById(dto.getItemId()).orElseThrow(EntityNotFoundException::new),
                dto.getSize()
        )).orElseThrow(EntityNotFoundException::new);
        return new OrderDetail()
                .setPricedItem(pricedItem)
                .setPrice(pricedItem.getPrice())
                .setQuantity(dto.getQuantity())
                .setComment(dto.getComment())
                .setPromoCode(promoCodesRepository.findByName(dto.getPromoCode()).orElse(null));
    }

    public Set<OrderDetail> createEntities(Set<CreateDetailDto> dtoSet ){
        return dtoSet.stream().map(this::createEntity).collect(Collectors.toSet());
    }

    public GetDetailDto createDto(OrderDetail detail){
        Item item = detail.getPricedItem().getItem();
        Category category = item.getCategory();

        return new GetDetailDto()
                .setId(item.getId())
                .setCategory_id(category.getId())
                .setCategory_name(category.getName())
                .setDescription(item.getDescription())
                .setComment(detail.getComment())
                .setName(item.getName())
                .setPrice(PriceMapper.createDto(detail))
                .setImgPath(item.getImgPath() != null ? item.getImgPath() : category.getImgPath());
    }

    public Set<GetDetailDto> createDtos(Set<OrderDetail> detailSet){
        return detailSet.stream().map(this::createDto).collect(Collectors.toSet());
    }
}

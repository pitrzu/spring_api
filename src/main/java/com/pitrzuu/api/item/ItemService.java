package com.pitrzuu.api.item;

import com.pitrzuu.api.item.category.ICategoryRepository;
import com.pitrzuu.api.item.dto.CreateItemDto;
import com.pitrzuu.api.item.dto.ItemDto;
import com.pitrzuu.api.item.dto.PriceDto;
import com.pitrzuu.api.item.pricing.ESize;
import com.pitrzuu.api.item.pricing.IPricedItemRepository;
import com.pitrzuu.api.item.pricing.PricedItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ItemService{
    public ItemService( ICategoryRepository categoriesRepository,
                        IItemRepository itemsRepository,
                        IPricedItemRepository pricedItemsRepository ){
        this.categoriesRepository = categoriesRepository;
        this.itemsRepository = itemsRepository;
        this.pricedItemsRepository = pricedItemsRepository;
    }

    private final ICategoryRepository categoriesRepository;
    private final IItemRepository itemsRepository;
    private final IPricedItemRepository pricedItemsRepository;

    public List<ItemDto> getItems(){
        return itemsRepository
                .findAll()
                .stream()
                .map(item ->
                        new ItemDto(item)
                                .setPrices(pricedItemsRepository.findByItem_Id(item.getId())
                                        .stream()
                                        .map(pricedItem -> new PriceDto(pricedItem.getSize().name(), pricedItem.getPrice()))
                                        .collect(Collectors.toSet()))
                )
                .collect(Collectors.toList());
    }

    @Transactional
    @Modifying
    public ItemDto addItem( CreateItemDto itemDto ){
        Item item = new Item()
                .setCategory(categoriesRepository.findById(itemDto.getCategoryId()).orElseThrow())
                .setDescription(itemDto.getDescription())
                .setName(itemDto.getName())
                .setImgPath(itemDto.getImgPath());
        Set<PricedItem> pricedItems = itemDto
                .getPrices()
                .stream()
                .map(priceDto -> new PricedItem()
                        .setItem(item)
                        .setPrice(priceDto.getPrice())
                        .setSize(ESize.valueOf(priceDto.getSize()))
                ).collect(Collectors.toSet());
        itemsRepository.saveAndFlush(item);
        pricedItemsRepository.saveAll(pricedItems);
        return new ItemDto(item).setPrices(pricedItemsRepository.findByItem_Id(item.getId())
                .stream()
                .map(pricedItem -> new PriceDto(pricedItem.getSize().name(), pricedItem.getPrice()))
                .collect(Collectors.toSet()));
    }

    @Transactional
    @Modifying
    public void removeUser( Integer id ){
        itemsRepository.deleteById(id);
    }
}

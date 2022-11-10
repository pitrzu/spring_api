package com.pitrzuu.api.order;

import com.pitrzuu.api.detail.DetailMapper;
import com.pitrzuu.api.order.dto.CreateOrderDto;
import com.pitrzuu.api.order.dto.GetOrderDto;
import com.pitrzuu.api.person.IPersonRepository;
import com.pitrzuu.api.person.PersonMapper;
import com.pitrzuu.api.promocode.IPromoCodeRepository;
import com.pitrzuu.api.promocode.PromoCodeMapper;
import com.pitrzuu.api.status.StatusMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper{
    public OrderMapper( IPromoCodeRepository promoCodesRepository,
                        IPersonRepository peopleRepository,
                        PersonMapper personMapper,
                        DetailMapper detailMapper,
                        StatusMapper statusMapper,
                        PromoCodeMapper promoCodeMapper ){
        this.promoCodesRepository = promoCodesRepository;
        this.peopleRepository = peopleRepository;
        this.personMapper = personMapper;
        this.detailMapper = detailMapper;
        this.statusMapper = statusMapper;
        this.promoCodeMapper = promoCodeMapper;
    }

    private final IPromoCodeRepository promoCodesRepository;
    private final IPersonRepository peopleRepository;
    private final PersonMapper personMapper;
    private final DetailMapper detailMapper;
    private final StatusMapper statusMapper;
    private final PromoCodeMapper promoCodeMapper;

    public Order createEntity( CreateOrderDto dto ){
        return new Order()
                .setAwaitedTime(dto.getAwaitedTime())
                .setCustomerComment(dto.getCustomerComment())
                .setPromoCode(dto.getPromoCode().isPresent() ?
                        promoCodesRepository.findByName(dto.getPromoCode().get()).orElseThrow(EntityNotFoundException::new) :
                        null
                ).setPerson(dto.getPersonId().isPresent() ?
                        peopleRepository.findById(
                                dto.getPersonId().get()
                        ).orElseThrow(EntityNotFoundException::new) :
                        personMapper.createEntity(
                                dto.getPerson().orElseThrow(IllegalArgumentException::new)
                        )
                ).setOrderDetails(detailMapper.createEntities(dto.getOrdered()));
    }

    public GetOrderDto createDto( Order order ){
        return new GetOrderDto()
                .setAwaitedTime(order.getAwaitedTime())
                .setCreationTime(order.getCreationTime())
                .setPromisedTime(order.getPromisedTime())
                .setId(order.getId())
                .setPerson(personMapper.createDto(order.getPerson()))
                .setOrdered(detailMapper.createDtos(order.getOrderDetails()))
                .setStatus(statusMapper.createDto(order.getLatestStatus()))
                .setComment(order.getCustomerComment())
                .setPromoCode(order.getPromoCode() != null ? promoCodeMapper.createDto(order.getPromoCode()) : null)
                .setTotalPrice(order.getTotalPrice());
    }
}

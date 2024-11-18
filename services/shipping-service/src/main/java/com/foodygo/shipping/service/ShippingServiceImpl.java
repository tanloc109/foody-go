package com.foodygo.shipping.service;

import com.foodygo.shipping.dto.response.ShippingByBranchResponse;
import com.foodygo.shipping.dto.response.ShippingByShipperResponse;
import com.foodygo.shipping.entity.Shipper;
import com.foodygo.shipping.entity.Shipping;
import com.foodygo.shipping.exception.IdNotFoundException;
import com.foodygo.shipping.mapper.ShipperMapper;
import com.foodygo.shipping.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {

    private final ShippingRepository repo;
    private final ShipperService shipperService;

    @Override
    public Shipping save(Shipping shipping) {
        return repo.save(shipping);
    }

    @Override
    public Shipping findById(Integer id) {
        return repo.findById(id).orElseThrow(
                () -> new IdNotFoundException("Cannot find shipping with id: " + id)
        );
    }

    @Override
    public List<Shipping> findAll() {
        return repo.findAllActive();
    }

    @Override
    public Shipping delete(Shipping shipping) {
        shipping.setDeleted(true);
        return repo.save(shipping);
    }

    @Override
    public ShippingByShipperResponse getShippingsByShipperId(Integer shipperId) {
        Shipper shipper = shipperService.findById(shipperId);
        return ShippingByShipperResponse.builder()
                .shipper(ShipperMapper.INSTANCE.toDTO(shipper))
                .build();
    }

    @Override
    public ShippingByBranchResponse getShippingsByBranchId(Integer branchId) {
        return null;
    }
}

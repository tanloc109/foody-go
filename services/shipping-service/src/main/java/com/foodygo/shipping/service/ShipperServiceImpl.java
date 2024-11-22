package com.foodygo.shipping.service;

import com.foodygo.shipping.dto.request.ShipperCreationRequest;
import com.foodygo.shipping.dto.request.ShipperUpdateRequest;
import com.foodygo.shipping.dto.response.ShipperCreationUpdateResponse;
import com.foodygo.shipping.entity.Shipper;
import com.foodygo.shipping.exception.IdNotFoundException;
import com.foodygo.shipping.repository.ShipperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipperServiceImpl implements ShipperService {

    private final ShipperRepository repo;

    @Override
    public Shipper save(Shipper shipper) {
        return repo.save(shipper);
    }

    @Override
    public Shipper findById(Integer id) {
        return repo.findById(id).orElseThrow(
                () -> new IdNotFoundException("Cannot find shipper with id: " + id)
        );
    }

    @Override
    public List<Shipper> findAll() {
        return repo.findAllActive();
    }

    @Override
    public Shipper delete(Shipper shipper) {
        shipper.setDeleted(true);
        return repo.save(shipper);
    }

    @Override
    public ShipperCreationUpdateResponse createShipper(ShipperCreationRequest request) {
        return null;
    }

    @Override
    public ShipperCreationUpdateResponse updateShipper(ShipperUpdateRequest request) {
        return null;
    }
}

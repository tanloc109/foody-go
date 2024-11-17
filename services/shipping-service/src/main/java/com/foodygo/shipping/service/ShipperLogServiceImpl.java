package com.foodygo.shipping.service;

import com.foodygo.shipping.entity.ShipperLog;
import com.foodygo.shipping.exception.IdNotFoundException;
import com.foodygo.shipping.repository.ShipperLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipperLogServiceImpl implements ShipperLogService {

    private final ShipperLogRepository repo;

    @Override
    public ShipperLog save(ShipperLog shipperLog) {
        return repo.save(shipperLog);
    }

    @Override
    public ShipperLog findById(Integer id) {
        return repo.findById(id).orElseThrow(
                () -> new IdNotFoundException("Cannot find shipper log of id " + id)
        );
    }

    @Override
    public List<ShipperLog> findAll() {
        return repo.findAllActive();
    }

    @Override
    public ShipperLog delete(ShipperLog shipperLog) {
        shipperLog.setDeleted(true);
        return repo.save(shipperLog);
    }
}

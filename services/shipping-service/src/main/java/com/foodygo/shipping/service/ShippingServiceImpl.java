package com.foodygo.shipping.service;

import com.foodygo.shipping.dto.request.ShippingCreationRequest;
import com.foodygo.shipping.dto.response.ShippingByBranchResponse;
import com.foodygo.shipping.dto.response.ShippingByShipperResponse;
import com.foodygo.shipping.dto.response.ShippingCreationResponse;
import com.foodygo.shipping.entity.Shipper;
import com.foodygo.shipping.entity.Shipping;
import com.foodygo.shipping.entity.enums.ShippingStatus;
import com.foodygo.shipping.exception.IdNotFoundException;
import com.foodygo.shipping.mapper.ShipperMapper;
import com.foodygo.shipping.mapper.ShippingMapper;
import com.foodygo.shipping.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {

    private final ShippingRepository repo;
    private final ShipperService shipperService;

    private final double basePrice = 5.0;
    private final double serviceFee = 10.0;
    private final double tax = 0.2;

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
    public List<Shipping> findByBranchId(Integer branchId) {
        return repo.findByBranchId(branchId);
    }

    @Override
    public Shipping findByOrderId(Integer orderId) {
        return repo.findByOrderId(orderId).orElseThrow(
                () -> new IdNotFoundException("Cannot find shipping with order id: " + orderId)
        );
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
        List<Shipping> shippings = findByBranchId(branchId);
        return ShippingByBranchResponse.builder()
                .branch(
                        ShippingByBranchResponse.Branch.builder()
                                .branchId(branchId)
                                .branchName("I don't have this info")
                                .shippings(shippings.stream().map(ShippingMapper.INSTANCE::toDTO).toList())
                                .build()
                )
                .build();
    }

    @Override
    public ShippingCreationResponse createShipping(ShippingCreationRequest request) {
        double calculatedDistance = calculateDistance(request.customerId(), request.branchId());
        double calculatedFee = calculateFee(calculatedDistance);

        Shipping shipping = save(Shipping
                .builder()
                .distance(calculatedDistance)
                .fee(calculatedFee)
                .orderId(request.orderId())
                .branchId(request.branchId())
                .customerId(request.customerId())
                .status(ShippingStatus.CREATED)
                .build()
        );

        notfifyShipperOfNewShipping(shipping.getId());
        return ShippingMapper.INSTANCE.toCreateDTO(shipping);
    }

    @Override
    public Double calculateFee(Double distance) {
        return (distance * basePrice + serviceFee) * (1 + tax);
    }

    //KAFKA - NOTIFY NEW SHIPPING
    private void notfifyShipperOfNewShipping(Integer shippingId) {

    }

    //CALL LOCATION SERVICE : CALCULATE DISTANCE
    private double calculateDistance(Integer customerId, Integer branchId) {
        return 5.0;
    }

    //CALL LOCATION SERVICE : GET BRANCH NAME
    private String getBranchName(Integer branchId) {
        return "HELLO";
    }
}

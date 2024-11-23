package com.foodygo.shipping.service;

import com.foodygo.shipping.dto.request.ShipperCreationRequest;
import com.foodygo.shipping.dto.request.ShipperUpdateRequest;
import com.foodygo.shipping.dto.response.ShipperCreationUpdateResponse;
import com.foodygo.shipping.dto.response.ShipperResponse;
import com.foodygo.shipping.entity.Shipper;
import com.foodygo.shipping.entity.enums.ShipperStatus;
import com.foodygo.shipping.exception.IdNotFoundException;
import com.foodygo.shipping.exception.ShipperInactiveException;
import com.foodygo.shipping.mapper.ShipperMapper;
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
        return repo.findByIdNotDeleted(id).orElseThrow(
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
        Shipper shipper = save(
                Shipper.builder()
                        .citizenId(request.citizenId())
                        .photo(request.photo())
                        .motoModel(request.motoModel())
                        .licensePlate(request.licensePlate())
                        .driverLicenseId(request.driverLicenseId())
                        .driverLicensePhoto(request.driverLicensePhoto())
                        .status(ShipperStatus.ACTIVE)
                        .build()
        );
        return ShipperMapper.INSTANCE.toCreateResponse(shipper);
    }

    @Override
    public ShipperCreationUpdateResponse updateShipper(Integer shipperId, ShipperUpdateRequest request) {
        Shipper shipper = findById(shipperId);
        shipper.setCitizenId(request.citizenId());
        shipper.setPhoto(request.photo());
        shipper.setMotoModel(request.motoModel());
        shipper.setLicensePlate(request.licensePlate());
        shipper.setDriverLicenseId(request.driverLicenseId());
        shipper.setDriverLicensePhoto(request.driverLicensePhoto());
        shipper.setStatus(request.status());
        return ShipperMapper.INSTANCE.toCreateResponse(shipper);
    }

    @Override
    public List<ShipperResponse> getAllActiveShipper() {
        return findAll().stream().map(ShipperMapper.INSTANCE::toResponse).toList();
    }

    @Override
    public ShipperResponse getActiveShipper(Integer shipperId) {
        Shipper shipper = findById(shipperId);
        if (!shipper.isAvailable()) {
            throw new ShipperInactiveException("This shipper is not available");
        }
        return ShipperMapper.INSTANCE.toResponse(shipper);
    }

    @Override
    public void deleteShipper(Integer shipperId) {
        Shipper shipper = findById(shipperId);
        delete(shipper);
    }
}

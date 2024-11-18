package com.foodygo.shipping.configuration;

import com.foodygo.shipping.entity.Shipper;
import com.foodygo.shipping.entity.ShipperLog;
import com.foodygo.shipping.entity.Shipping;
import com.foodygo.shipping.entity.enums.ShipperLogAction;
import com.foodygo.shipping.entity.enums.ShipperStatus;
import com.foodygo.shipping.repository.ShipperLogRepository;
import com.foodygo.shipping.repository.ShipperRepository;
import com.foodygo.shipping.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final ShipperRepository shipperRepository;
    private final ShippingRepository shippingRepository;
    private final ShipperLogRepository shipperLogRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists
        if (shipperRepository.count() > 0 || shippingRepository.count() > 0 || shipperLogRepository.count() > 0) {
            log.info("Data already exists. Skipping initialization.");
            return;
        }
        Random random = new Random();

        // Generate Shippers
        List<Shipper> shippers = new ArrayList<>();
        for (int i = 1; i <= 50; i++) { // Generate 50 shippers
            Shipper shipper = Shipper.builder()
                    .citizenId("CITIZEN_" + i)
                    .photo("https://example.com/photo_" + i + ".jpg")
                    .motoModel("Model_" + random.nextInt(10))
                    .licensePlate("ABC-" + (1000 + i))
                    .driverLicenseId("DL_" + (10000 + i))
                    .driverLicensePhoto("https://example.com/license_" + i + ".jpg")
                    .status(ShipperStatus.ACTIVE) // Assuming ShipperStatus.AVAILABLE exists
                    .build();
            shippers.add(shipper);
        }
        shipperRepository.saveAll(shippers);

        // Generate Shipping Records
        List<Shipping> shippings = new ArrayList<>();
        for (Shipper shipper : shippers) {
            for (int i = 1; i <= random.nextInt(5) + 1; i++) { // 1 to 5 shippings per shipper
                Shipping shipping = Shipping.builder()
                        .distance(5.0 + random.nextDouble() * 15.0) // Random distance between 5-20 km
                        .fee(50.0 + random.nextDouble() * 100.0) // Random fee between 50-150
                        .orderId(random.nextInt(1000) + 1) // Random order ID
                        .shipper(shipper)
                        .build();
                shippings.add(shipping);
            }
        }
        shippingRepository.saveAll(shippings);

        // Generate Shipper Logs
        List<ShipperLog> shipperLogs = new ArrayList<>();
        for (Shipping shipping : shippings) {
            for (int i = 1; i <= random.nextInt(3) + 1; i++) { // 1 to 3 logs per shipping
                ShipperLog log = ShipperLog.builder()
                        .orderId(shipping.getOrderId())
                        .time(Instant.now().minusSeconds(random.nextInt(10000))) // Random past time
                        .action(ShipperLogAction.ACCEPTED) // Assuming STARTED action exists
                        .shipper(shipping.getShipper())
                        .build();
                shipperLogs.add(log);
            }
        }
        shipperLogRepository.saveAll(shipperLogs);

        log.info("Data initialization completed:");
        log.info("Shippers: {}", shippers.size());
        log.info("Shippings: {}", shippings.size());
        log.info("Logs: {}", shipperLogs.size());
    }
}

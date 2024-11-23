package com.foodygo.location.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodygo.location.dto.response.ProvinceResponseDTO;
import com.foodygo.location.entities.District;
import com.foodygo.location.entities.Province;
import com.foodygo.location.entities.Ward;
import com.foodygo.location.mapper.ProvinceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final WebClient webClient;
    private final ProvinceService provinceService;
    private final DistrictService districtService;
    private final WardService wardService;

    @Override
    public List<ProvinceResponseDTO> getAllLocations() {
        List<Province> provinceList = provinceService.findAll();
        return provinceList.stream().map(ProvinceMapper.INSTANCE::toDTO).toList();
    }

    @Override
    @Transactional
    public void initLocation() {
        JsonNode provinceData = getData("/provinces?page=0&size=63");
        if (provinceData != null && provinceData.isArray()) {
            provinceData.forEach(dataItem -> {
                Province province = Province.builder()
                        .id(Integer.parseInt(dataItem.get("id").asText()))
                        .slug(dataItem.get("slug").asText())
                        .name(dataItem.get("name").asText())
                        .isDeleted(false)
                        .build();
                provinceService.save(province);
            });
        }

        JsonNode districtData = getData("/districts?page=0&size=705");
        if (districtData != null && districtData.isArray()) {
            districtData.forEach(dataItem -> {
                District district = District.builder()
                        .id(Integer.parseInt(dataItem.get("id").asText()))
                        .name(dataItem.get("name").asText())
                        .isDeleted(false)
                        .province(provinceService.findById(dataItem.get("provinceId").asInt()))
                        .build();
                districtService.save(district);
            });
        }
        for (int i = 0; i < 11; i++) {
            JsonNode wardData = getData("/wards?page=" + i + "&size=1000");
            if (wardData != null && wardData.isArray()) {
                wardData.forEach(dataItem -> {
                    Ward ward = Ward.builder()
                            .id(Integer.parseInt(dataItem.get("id").asText()))
                            .name(dataItem.get("name").asText())
                            .district(districtService.findById(dataItem.get("districtId").asInt()))
                            .isDeleted(false)
                            .build();
                    wardService.save(ward);
                });
            }
        }
    }

    private JsonNode getData(String uri) {
        try {
            String response = webClient
                    .get()
                    .uri(uri)
                    .retrieve()
                    .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                            clientResponse -> clientResponse
                                    .bodyToMono(String.class)
                                    .flatMap(errorBody -> {
                                        if (clientResponse.statusCode().value() == 404) {
                                            return Mono.error(new RuntimeException("Lổ dồi các cháu ơi"));
                                        } else {
                                            return Mono.error(new RuntimeException("API error" + errorBody));
                                        }
                                    }))
                    .bodyToMono(String.class)
                    .block();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response);
            return jsonNode.get("data");
        } catch (Exception ex) {
            throw new RuntimeException("Unhandled exception: " + ex.getMessage());
        }
    }
}

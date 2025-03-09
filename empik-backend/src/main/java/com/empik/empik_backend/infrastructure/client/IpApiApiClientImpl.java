package com.empik.empik_backend.infrastructure.client;

import com.empik.empik_backend.infrastructure.client.api.IpApiClient;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
class IpApiApiClientImpl implements IpApiClient {

    private final RestClient restClient = RestClient.create();

    @Value("${client.ip-api.url}")
    private String path;

    @Override
    public String getCountryByRequestIp(String ip) {

        var url =path+ip;
        ResponseEntity<CountryResponse> response = restClient.get()
                .uri(url)
                .retrieve()
                .toEntity(CountryResponse.class);
        if(!response.getStatusCode().is2xxSuccessful()){
           log.warn("WARN! Problem with connection/request/response to: "+ url);
           return null;
        }
        CountryResponse countryResponse = response.getBody();
        if(countryResponse == null || countryResponse.getCountry() == null){
            log.warn("WARN! Ip api returned null country for: "+ url);
            return null;
        }
        return countryResponse.getCountry();
    }

    @Data
    private static class CountryResponse{
        private String country;
    }
}

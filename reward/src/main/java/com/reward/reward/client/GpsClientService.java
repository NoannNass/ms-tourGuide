package com.reward.reward.client;




import com.reward.reward.dto.AttractionDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GpsClientService {
    private final RestTemplate restTemplate;

    public GpsClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${gps.url}")
    private String gpsServiceUrl;

    public List<AttractionDTO> getAttractions() {
        return restTemplate.exchange(
                gpsServiceUrl + "/locations/attractions",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AttractionDTO>>() {}
        ).getBody();
    }




}

package com.user.user.gateway.client;

import com.user.user.gateway.dto.AttractionDTO;
import com.user.user.gateway.dto.LocationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;

@Slf4j //permet la journalisation des exceptions via log
public class GpsClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public GpsClient(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

   // Recupère la localisation d'un user depuis le service GPS
    public Optional<LocationDTO> getUserLocation( Long userId) {

        try {
            //Construction de l'URL complète pour appeler le service GPS
            String url = String.format("%s/location/%d", baseUrl, userId);
            //log.debug("Calling GPS service at {}", url);

            //Appel du service GPS
            ResponseEntity<LocationDTO> response = restTemplate.getForEntity(url, LocationDTO.class);

            return Optional.ofNullable(response.getBody());
        }catch (RestClientException e){
            //En cas d'erreur, nous journalisons l'erreur et lançons une exception métier
            log.error("Error fetching user location",userId, e);
            return Optional.empty();
        }
//            //En cas d'erreur, nous journalisons l'erreur et lançons une exception métier
//            log.error("Error fetching user location",userId, e);
////            throw new ServiceCommunicationException("Error fetching user location", e);
        }

        // Méthode pour obtenir les attractions proches d'un utilisateur
//public List<AttractionDTO> getNearbyAttractions(LocationDTO location, Double radius) {
//
//}

    }

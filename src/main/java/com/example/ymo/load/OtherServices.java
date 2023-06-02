package com.example.ymo.load;

import com.example.ymo.DTO.AnketDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

public class OtherServices {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<AnketDTO> getAnketDTOs() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String token = getTokenFromAuthService();
        headers.add("Authorization", "Bearer " + token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
        return restTemplate.exchange("http://192.168.11.252:8085/ankets",
                HttpMethod.GET, request, new ParameterizedTypeReference<List<AnketDTO>>() {
        }).getBody();
    }

    private String getTokenFromAuthService() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("username", "admin@gmail.com");
        body.add("password", "admin");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + "VlNUVV9FTEVDVFJPTklDSk9VUk5BTF9DTElFTlQ6VlNUVV9FTEVDVFJPTklDSk9VUk5BTF9DTElFTlQ=");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange("http://192.168.11.252:8888/token?grant_type=password",
                HttpMethod.POST, request, new ParameterizedTypeReference<String>() {
                });
        return Objects.requireNonNull(response.getBody()).split("\"")[3];
    }
}
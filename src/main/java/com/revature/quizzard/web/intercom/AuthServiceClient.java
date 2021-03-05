package com.revature.quizzard.web.intercom;

import com.revature.quizzard.dtos.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthServiceClient {

    private RestTemplate restClient;
    private String authServiceUrl = "http://localhost:8080/token";

    @Autowired
    public AuthServiceClient(RestTemplate restClient) {
        this.restClient = restClient;
    }

    public String generateTokenFromPrincipal(Principal principal) {
        return restClient.postForObject(authServiceUrl, principal, String.class);
    }

    public boolean validateToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("quizzard-token", token);
        return restClient.getForEntity(authServiceUrl, Boolean.class).getBody();
    }

    public String getTokenAuthorities(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("quizzard-token", token);
        return restClient.exchange(authServiceUrl + "/authorities", HttpMethod.GET, new HttpEntity<>(headers), String.class).getBody();
    }

}

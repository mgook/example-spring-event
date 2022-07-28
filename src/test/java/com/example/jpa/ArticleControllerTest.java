package com.example.jpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.util.UriComponentsBuilder;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArticleControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void t() {
        String id = restTemplate.getForEntity(UriComponentsBuilder.fromPath("/create").toUriString(), String.class)
                .getBody();

        restTemplate.getForEntity(UriComponentsBuilder.fromPath("/expire").queryParam("id", id).toUriString(), Void.class);

        ArticleResponse response = restTemplate.getForEntity(UriComponentsBuilder.fromPath("/get").queryParam("id", id).toUriString(), ArticleResponse.class).getBody();
        System.out.println(response.toString());
    }
}
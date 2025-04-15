package com.prueba.itx.endtoend;

import com.prueba.itx.ItxApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.model.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ItxApplication.class)
class ItxApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private TestRestTemplate restTemplate;


    @BeforeEach
    void setUp() {

    }

    @Test
    public void testEmptyResult() {
        ResponseEntity<PriceDto> response =
                this.getCallResponse(this.restTemplate, "1", "1", "2023-01-01T00:00:00");
        assertThat(HttpStatus.NO_CONTENT).isEqualTo(response.getStatusCode());
        PriceDto result = response.getBody();
        assertThat(result).isEqualTo(null);
    }

    @Test
    public void testGetPriceAt10amOnDay14() {
        ResponseEntity<PriceDto> response =
                this.getCallResponse(this.restTemplate, "35455", "1", "2020-06-14T10:00");
        PriceDto result = response.getBody();
        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(result).isNotNull();
        assertThat(result.getPrice()).isEqualTo(35.5);
    }

    @Test
    public void testGetPriceAt4pmOnDay14() {
        ResponseEntity<PriceDto> response =
                this.getCallResponse(this.restTemplate, "35455", "1", "2020-06-14T16:00:00");
        PriceDto result = response.getBody();
        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(result).isNotNull();
        assertThat(result.getPrice()).isEqualTo(25.45);
    }


    @Test
    public void testGetPriceAt10amOnDay15() {
        ResponseEntity<PriceDto> response =
                this.getCallResponse(this.restTemplate, "35455", "1", "2020-06-15T10:00:00");
        PriceDto result = response.getBody();

        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(result).isNotNull();
        assertThat(result.getPrice()).isEqualTo(30.5);
    }

    @Test
    public void testGetPriceAt9pmOnDay16() {
        ResponseEntity<PriceDto> response =
                this.getCallResponse(this.restTemplate, "35455", "1", "2020-06-16T21:00:00");
        PriceDto result = response.getBody();

        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(result).isNotNull();
        assertThat(result.getPrice()).isEqualTo(38.95);
    }
    @Test
    public void testGetPriceAt9pmOnDay14() {
        ResponseEntity<PriceDto> response =
                this.getCallResponse(this.restTemplate, "35455", "1", "2020-06-14T21:00:00");
        PriceDto result = response.getBody();

        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        assertThat(result).isNotNull();
        assertThat(result.getProductId()).isEqualTo(35455L);
        assertThat(result.getPrice()).isEqualTo(35.50);

    }


    public static ResponseEntity<PriceDto> getCallResponse(
            TestRestTemplate template, String productId, String brandId, String date) {
        String url = "/prices";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("applicationDate", date)
                .queryParam("productId", productId)
                .queryParam("brandId", brandId);

        return template.exchange(builder.toUriString(), HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
    }

}

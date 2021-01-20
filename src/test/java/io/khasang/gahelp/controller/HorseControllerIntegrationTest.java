package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Horse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class HorseControllerIntegrationTest {
    private static final String ROOT = "http://localhost:8080/horse";
    private static final String ADD = "/add";
    private static final String ALL = "/all";
    private static final String GET = "/get";
    private static final String DELETE = "/delete";

    @Test
    public void testHomePage() throws Exception {
        AppController controller = new AppController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.view().name("status"));
    }

    @Test
    public void checkHorseAdd() {
        Horse risak = createHorse();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Horse> responseEntity = template.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Horse.class,
                risak.getId()
        );
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Horse receivedHorse = responseEntity.getBody();
        Assert.assertNotNull(receivedHorse);
    }

    @Test
    public void checkAllHorses() {
        createHorse();
        createHorse();

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Horse>> responseEntity = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Horse>>() {
                }
        );
        List<Horse> horses = responseEntity.getBody();
        Assert.assertNotNull(horses);
    }

    private Horse createHorse() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Horse horse = prefillHorse();
        HttpEntity<Horse> entity = new HttpEntity<>(horse, headers);
        RestTemplate restTemplate = new RestTemplate();
        Horse createdHorse = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Horse.class).getBody();

        Assert.assertNotNull(createdHorse);
        Assert.assertEquals("Risak", createdHorse.getName());
        return createdHorse;
    }

    private Horse prefillHorse() {
        Horse horse = new Horse();
        horse.setName("Risak");
        horse.setDescription("fast");
        return horse;
    }
}

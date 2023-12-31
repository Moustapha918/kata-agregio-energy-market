package com.agregio.kata.infrastructure.powerparks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static com.agregio.kata.infrastructure.TestUtils.toJson;
import static com.agregio.kata.infrastructure.WebConstants.API_ROOT_URL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class PowerParkControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user")
    public void should_create_new_power_park() throws Exception {
        String offerRequest = toJson("create-power-park-request.json", "request-data");
        String createdOffer = toJson("created-power-park.json", "expected-data");
        this.mockMvc.perform(
                        post(API_ROOT_URL +  "/parks")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(offerRequest))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(createdOffer));
    }
}

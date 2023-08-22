package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerRepository customerRepo;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnCustomersByState() throws Exception {
        Customer test = new Customer();
        test.setFirstName("Catalina");
        test.setLastName("Martinez");
        test.setEmail("catamtz3@gmail.com");
        test.setCompany("Netflix");
        test.setPhone("509-686-2020");
        test.setAddress1("4738 22nd Ave NE");
        test.setAddress2("1636 Douglas Ave");
        test.setCity("Seattle");
        test.setState("Washington");
        test.setPostalCode("98105");
        test.setCountry("USA");
        String outputJson = mapper.writeValueAsString(test);

        // ACT
        mockMvc.perform(get("/customers/state/Washington"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void shouldReturnNewCustomerOnPostRequest() throws Exception {
        // ARRANGE
        Customer test = new Customer();
        test.setFirstName("Catalina");
        test.setLastName("Martinez");
        test.setEmail("catamtz3@gmail.com");
        test.setCompany("Netflix");
        test.setPhone("509-686-2020");
        test.setAddress1("4738 22nd Ave NE");
        test.setAddress2("1636 Douglas Ave");
        test.setCity("Seattle");
        test.setState("Washington");
        test.setPostalCode("98105");
        test.setCountry("USA");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(test);

        // ACT
        mockMvc.perform(
                        post("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnCustomerById() throws Exception {

        Customer test = new Customer();
        test.setFirstName("Catalina");
        test.setLastName("Martinez");
        test.setEmail("catamtz3@gmail.com");
        test.setCompany("Netflix");
        test.setPhone("509-686-2020");
        test.setAddress1("4738 22nd Ave NE");
        test.setAddress2("1636 Douglas Ave");
        test.setCity("Seattle");
        test.setState("Washington");
        test.setPostalCode("98105");
        test.setCountry("USA");
        test.setId(2);

        String outputJson = mapper.writeValueAsString(test);

        mockMvc.perform(get("/customers/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdate() throws Exception {
        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        Customer test = new Customer();
        test.setFirstName("Catalina");
        test.setLastName("Martinez");
        test.setEmail("catamtz3@gmail.com");
        test.setCompany("Netflix");
        test.setPhone("509-686-2020");
        test.setAddress1("4738 22nd Ave NE");
        test.setAddress2("1636 Douglas Ave");
        test.setCity("Seattle");
        test.setState("Washington");
        test.setPostalCode("98105");
        test.setCountry("USA");
        test.setId(3);

        String inputJson = mapper.writeValueAsString(test);

        mockMvc.perform(
                        put("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteById() throws Exception {
        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates no Content
        mockMvc.perform(delete("/customers/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}

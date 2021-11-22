package com.kafkaOne.microservicebank.controller;

import com.kafkaOne.microservicebank.model.BankClient;
import com.kafkaOne.microservicebank.service.BankClientService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(BankClientController.class)
class BankClientControllerTest {

    @Autowired
    private BankClientController bankClientController;

    @MockBean
    private BankClientService bankClientService;

    @Autowired
    MockMvc mockMvc;


    @Test
    public void testExistence() throws Exception {
        assertNotNull(bankClientController, "BankClient Rest controller is null");
    }


    @Test
    public void getClientTest() throws Exception {
        BankClient bankClient = new BankClient(1L, 1l, "Alex",
                "Omsk", "12.04.1999");

        when(bankClientService.getClient(1L)).thenReturn(bankClient);
        ResponseEntity<BankClient> bankClient1 = bankClientController.getClient(1L);
        assertThat(bankClient1.getBody().getName()).isEqualTo("Alex");
        assertThat(bankClient1.getBody().getPaymentId()).isEqualTo(1L);

    }

}
package com.kafkaOne.microservicebank.service;

import com.kafkaOne.microservicebank.model.BankClient;
import com.kafkaOne.microservicebank.repositories.BankClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BankClientServiceImplTest {

    @MockBean
    private BankClientRepository repository;

    @Autowired
    private BankClientService bankClientService;

    @Test
    public void getClientTest(){
       Long id = 1L;
        when(repository.getById(any()))
                .thenReturn(new BankClient(1L, 1L, "Ann", "Kursk", "12.12.1999"));
        BankClient bankClient = bankClientService.getClient(1L);
        assertThat(bankClient.getClientId()).isEqualTo(1L);
        assertNotNull(bankClient, "failure - expected that bankClient not null");
    }

}
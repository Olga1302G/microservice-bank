package com.kafkaOne.microservicebank.service;

import com.kafkaOne.microservicebank.model.BankClient;

public interface BankClientService {
    BankClient getClient(Long id);
}

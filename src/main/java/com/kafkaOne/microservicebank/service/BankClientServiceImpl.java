package com.kafkaOne.microservicebank.service;

import com.kafkaOne.microservicebank.exception.BankClientNotFoundException;
import com.kafkaOne.microservicebank.model.BankClient;
import com.kafkaOne.microservicebank.repositories.BankClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankClientServiceImpl implements BankClientService{

    private BankClientRepository bankClientRepository;

    @Autowired
    public BankClientServiceImpl(BankClientRepository bankClientRepository){
        this.bankClientRepository=bankClientRepository;
    }
    @Override
    public BankClient getClient(Long clientId) {
        BankClient bankClient = bankClientRepository.getById(clientId);
        if (bankClient == null) {
            throw new BankClientNotFoundException(clientId);
        }
        return bankClient;
    }
}

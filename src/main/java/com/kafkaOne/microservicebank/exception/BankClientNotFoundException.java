package com.kafkaOne.microservicebank.exception;

import java.util.UUID;

public class BankClientNotFoundException extends RuntimeException{
    Long clientId;
    public BankClientNotFoundException(Long clientId){
        this.clientId = clientId;
    }
}

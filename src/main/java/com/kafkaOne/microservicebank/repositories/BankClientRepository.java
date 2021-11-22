package com.kafkaOne.microservicebank.repositories;

import com.kafkaOne.microservicebank.model.BankClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankClientRepository extends JpaRepository<BankClient, Long>{
}

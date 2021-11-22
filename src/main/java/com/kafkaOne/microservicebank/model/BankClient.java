package com.kafkaOne.microservicebank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Builder
public class BankClient implements Serializable {
    @Id
    @Column(name = "clientid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;

    @Column(name = "paymentid")
    private Long paymentId;

    @Column
    private String name;

    @Column
    private String city;

    @Column
    private String created;
}

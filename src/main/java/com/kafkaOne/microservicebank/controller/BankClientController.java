package com.kafkaOne.microservicebank.controller;

import com.kafkaOne.microservicebank.model.BankClient;
import com.kafkaOne.microservicebank.service.BankClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/banks")
@Api(value = "hello")
public class BankClientController {

    private BankClientService bankClientService;

    @Autowired
    public BankClientController(BankClientService bankClientService) {
        this.bankClientService = bankClientService;
    }

    @GetMapping("/{clientId}")
    @ApiOperation(value = "Отправка данных о клиенте банка в microservice-integrator")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное получение информации о клиенте"),
            @ApiResponse(code = 404, message = "Данный контролер не найден"),
            @ApiResponse(code = 403, message = "Операция запрещена"),
            @ApiResponse(code = 401, message = "Нет доступа к данной операции")}
    )
    public ResponseEntity<BankClient> getClient(@PathVariable("clientId") Long clientId) {
        BankClient bankClient = bankClientService.getClient(clientId);
        return new ResponseEntity<>(bankClient, HttpStatus.OK);

    }
}

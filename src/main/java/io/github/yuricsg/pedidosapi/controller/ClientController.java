package io.github.yuricsg.pedidosapi.controller;

import io.github.yuricsg.pedidosapi.model.Client;
import io.github.yuricsg.pedidosapi.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void salvar(@RequestBody Client client){
        service.salvar(client);
    }
}

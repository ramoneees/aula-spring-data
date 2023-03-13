package com.minhaapi.aula03.controller;

import ch.qos.logback.core.net.server.Client;
import com.minhaapi.aula03.ClienteDTO;
import com.minhaapi.aula03.dao.ClienteDAO;
import com.minhaapi.aula03.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class Aula03Controller {

    @Autowired
    private ClienteRepository clienteRepository;
    public List<ClienteDTO> listaCliente = new ArrayList<ClienteDTO>();
    public HashMap<Integer, ClienteDTO> clientes = new HashMap<Integer, ClienteDTO>();

    @PostMapping("/cliente")
    public ResponseEntity<ClienteDTO> adicionarCliente (@RequestBody @Valid ClienteDTO c){
         ClienteDAO clientePersistido = clienteRepository.save(c.toDao());
        return new ResponseEntity<ClienteDTO>(clientePersistido.toDTO(), HttpStatus.CREATED);
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<ClienteDTO>> verTodosClientes(){
        return ResponseEntity.ok().body(clienteRepository.findAll()
                    .stream()
                    .map(clienteDAO -> clienteDAO.toDTO())
                    .collect(Collectors.toList()));
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<ClienteDTO> getClientePorId(@PathVariable("id") Long id){
       Optional<ClienteDAO> cliente = clienteRepository.findById(id);
       if (cliente.isPresent()){
           return new ResponseEntity<ClienteDTO>(cliente.get().toDTO(), HttpStatus.OK);
       } else {
           return ResponseEntity.notFound().build();
       }
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<ClienteDTO> deletarClientePorId(@PathVariable("id") Long id){
        ClienteDAO cliente = new ClienteDAO();
        cliente.setId(id);
        clienteRepository.delete(cliente);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<ClienteDTO> atualizaCliente(@PathVariable("id") Long id, @RequestBody ClienteDTO c){
        c.setId(id);
        ClienteDAO clienteAtualizado = clienteRepository.save(c.toDao());
        return new ResponseEntity<ClienteDTO>(clienteAtualizado.toDTO(), HttpStatus.OK);
    }

}

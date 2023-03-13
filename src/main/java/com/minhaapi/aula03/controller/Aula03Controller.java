package com.minhaapi.aula03.controller;

import com.minhaapi.aula03.ClienteDTO;
import com.minhaapi.aula03.dao.ClienteDAO;
import com.minhaapi.aula03.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
public class Aula03Controller {

    @Autowired
    private ClienteRepository clienteRepository;
    public List<ClienteDTO> listaCliente = new ArrayList<ClienteDTO>();
    public HashMap<Integer, ClienteDTO> clientes = new HashMap<Integer, ClienteDTO>();

    @PostMapping("/cliente")
    public ResponseEntity<ClienteDTO> adicionarCliente (@RequestBody ClienteDTO c){
         ClienteDAO clientePersistido = clienteRepository.save(c.toDao());
        return new ResponseEntity<ClienteDTO>(clientePersistido.toDTO(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/cliente")
    public Collection<ClienteDTO> verTodosClientes(){
        return clientes.values();
    }

    @GetMapping("/cliente/{id}")
    public ClienteDTO getClientePorId(@PathVariable("id") int id){
        return clientes.get(id);
    }

    @DeleteMapping("/cliente/{id}")
    public ClienteDTO deletarClientePorId(@PathVariable("id") int id){
        return clientes.remove(id);
    }

    @PutMapping("/cliente/{id}")
    public ClienteDTO atualizaCliente(@PathVariable("id") int id, @RequestBody ClienteDTO c){
        return clientes.put(id,c);
    }

}

package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ControllerRestCliente {
    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente(123,"Eduardo alfoso","Alfons","arroz"),
            new Cliente(456,"Laura Sanchez","lauras","pass234"),
            new Cliente(789,"Alejandro Bolaños","sancheznt","perros"),
            new Cliente(275,"Julio Hernesto","JulioProfe","leia1031")
    ));

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return clientes;
    }

    @GetMapping("/clientes/{username}")
    public Cliente getCliente(@PathVariable String username){
        for (Cliente c : clientes){
            if(c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }

    @PostMapping("/clientes")
    public Cliente postCliente(@RequestBody Cliente cliente){
        clientes.add(cliente);
        return cliente;
    }

    @PutMapping("/clientes")
    public Cliente putCliente(@RequestBody Cliente cliente){
        for(Cliente c : clientes){
            if(c.getID() == cliente.getID()){
                c.setNombre(cliente.getNombre());
                c.setUsername(cliente.getUsername());
                c.setPassword(cliente.getPassword());
                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/clientes/{id}")
    public Cliente deleteCliente(@PathVariable int id){
        for(Cliente c : clientes){
            if (c.getID() == id){
                clientes.remove(c);
                return c;
            }
        }
        return null;
    }

    @PatchMapping("/clientes")
    public Cliente patchCliente(@RequestBody Cliente cliente){
        for(Cliente c : clientes){
            if(c.getID() == cliente.getID()){
                if(cliente.getNombre() != null){
                    c.setNombre(cliente.getNombre());
                }
                if(cliente.getUsername() != null){
                    c.setUsername(cliente.getUsername());
                }
                if(cliente.getPassword() != null){
                    c.setPassword(cliente.getPassword());
                }
                return c;
            }
        }
        return null;
    }
}

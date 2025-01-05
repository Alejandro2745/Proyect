package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControllerRestCliente {
    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente(123,"Eduardo alfoso","Alfons","arroz"),
            new Cliente(456,"Laura Sanchez","lauras","pass234"),
            new Cliente(789,"Alejandro Bolaños","sancheznt","perros"),
            new Cliente(275,"Julio Hernesto","JulioProfe","leia1031")
    ));

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Cliente> getClientes(){
        return clientes;
    }

    //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public Cliente getCliente(@PathVariable String username){
        for (Cliente c : clientes){
            if(c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }

    @PostMapping
    public Cliente postCliente(@RequestBody Cliente cliente){
        clientes.add(cliente);
        return cliente;
    }

    @PutMapping
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

    @DeleteMapping("/{id}")
    public Cliente deleteCliente(@PathVariable int id){
        for(Cliente c : clientes){
            if (c.getID() == id){
                clientes.remove(c);
                return c;
            }
        }
        return null;
    }

    @PatchMapping
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

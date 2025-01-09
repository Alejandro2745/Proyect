package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<List<Cliente>> getClientes(){
        return ResponseEntity.ok(clientes);
    }

    //@RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @GetMapping("/{username}")
    public ResponseEntity<?> getCliente(@PathVariable String username){
        for (Cliente c : clientes){
            if(c.getUsername().equalsIgnoreCase(username)) {
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encotrado con username: "+username);
    }

    @PostMapping
    public ResponseEntity<?> postCliente(@RequestBody Cliente cliente){
        clientes.add(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado exitosamente: "+cliente.getUsername());
    }

    @PutMapping
    public ResponseEntity<?> putCliente(@RequestBody Cliente cliente){
        for(Cliente c : clientes){
            if(c.getID() == cliente.getID()){
                c.setNombre(cliente.getNombre());
                c.setUsername(cliente.getUsername());
                c.setPassword(cliente.getPassword());
                return ResponseEntity.ok("Cliente modificado satisfactoriamente(ID): " + cliente.getID());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado (ID): " + cliente.getID());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable int id){
        for(Cliente c : clientes){
            if (c.getID() == id){
                clientes.remove(c);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente eliminado correctamente: "+id);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no existe (ID): "+id);
    }

    @PatchMapping
    public ResponseEntity<?> patchCliente(@RequestBody Cliente cliente){
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
                return ResponseEntity.ok("Cliente modificado correctamente (ID): "+cliente.getID());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado (ID): " + cliente.getID());
    }
}

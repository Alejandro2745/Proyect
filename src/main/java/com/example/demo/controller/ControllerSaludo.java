package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerSaludo {
    @GetMapping("/saludo/{nombre}")
    public String Greeting(@PathVariable String nombre){
        return "Hola "+nombre;
    }
}

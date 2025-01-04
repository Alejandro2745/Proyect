package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para verficiar palindromos
 */
@RestController
public class ControllerPalindromo {

    /**
     * Endpoint para verificar si una plabra es un palindromo
     * @param palabra Palabra a verificar
     * @return mensaje de si es palindromo o no
     */
    @GetMapping("/espalindromo/{palabra}")
    public String palindromo(@PathVariable String palabra){

        StringBuilder reverso =new StringBuilder(palabra);
        reverso.reverse();
        String palabrainvertida = reverso.toString();
        if (palabra.equals(palabrainvertida)){
            return "La palabra: "+palabra+" es un palindromo";
        }
        else{
            return "La palabra: "+palabra+" NO es un palindromo";
        }

    }
}

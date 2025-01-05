package com.example.demo.domain;

public class Cliente {
    private int ID;
    private String nombre;
    private String username;
    private String password;

    // Contructor
    public Cliente(int ID, String nombre, String username, String password) {
        this.ID = ID;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

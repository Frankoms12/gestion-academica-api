package com.escuela.gestionacademica.dto;

public class EstudianteDTO {
    private Integer id;
    private String nombreCompleto;
    private String email;
    private int edad;

    // Constructor vacío
    public EstudianteDTO() {
    }

    // Constructor con todos los campos para facilitar la creación
    public EstudianteDTO(Integer id, String nombreCompleto, String email, int edad) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.edad = edad;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
package com.escuela.gestionacademica.dto;

public class CursosPorProfesorDTO {
    private String nombreProfesor;
    private Long totalCursos;

    // Constructor para la proyección JPQL
    public CursosPorProfesorDTO(String nombreProfesor, Long totalCursos) {
        this.nombreProfesor = nombreProfesor;
        this.totalCursos = totalCursos;
    }

    // Getters
    public String getNombreProfesor() { return nombreProfesor; }
    public Long getTotalCursos() { return totalCursos; }
}
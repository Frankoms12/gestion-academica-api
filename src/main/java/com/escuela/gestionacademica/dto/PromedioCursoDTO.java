package com.escuela.gestionacademica.dto;

public class PromedioCursoDTO {
    private String nombreCurso;
    private Double promedioNota;

    // Constructor para la proyección JPQL
    public PromedioCursoDTO(String nombreCurso, Double promedioNota) {
        this.nombreCurso = nombreCurso;
        this.promedioNota = promedioNota;
    }

    // Getters
    public String getNombreCurso() { return nombreCurso; }
    public Double getPromedioNota() { return promedioNota; }
}
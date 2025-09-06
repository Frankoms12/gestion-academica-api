package com.escuela.gestionacademica.dto;

public class EstudiantesPorCicloDTO {
    private String ciclo;
    private Long totalEstudiantes;

    // Constructor para la proyección JPQL
    public EstudiantesPorCicloDTO(String ciclo, Long totalEstudiantes) {
        this.ciclo = ciclo;
        this.totalEstudiantes = totalEstudiantes;
    }

    // Getters
    public String getCiclo() { return ciclo; }
    public Long getTotalEstudiantes() { return totalEstudiantes; }
}
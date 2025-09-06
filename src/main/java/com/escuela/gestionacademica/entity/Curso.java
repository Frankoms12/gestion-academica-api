package com.escuela.gestionacademica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_curso")
    private String nombreCurso;

    private String descripcion;

    // --- NUEVA RELACIÓN ---
    // Un profesor puede tener muchos cursos, pero un curso pertenece a un solo profesor.
    @ManyToOne(fetch = FetchType.LAZY) // fetch=LAZY es una buena práctica para el rendimiento
    @JoinColumn(name = "profesor_id") // Esta será la columna de clave foránea en la tabla "curso"
    private Profesor profesor;
    // ----------------------
    
    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombreCurso() { return nombreCurso; }
    public void setNombreCurso(String nombreCurso) { this.nombreCurso = nombreCurso; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    // --- NUEVOS GETTERS Y SETTERS ---
    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }
    // -------------------------------
}
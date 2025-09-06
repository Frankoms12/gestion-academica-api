package com.escuela.gestionacademica.repository;

import com.escuela.gestionacademica.dto.CursosPorProfesorDTO;
import com.escuela.gestionacademica.entity.Curso;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    // Reporte 1: Contar cursos por profesor
    @Query("SELECT new com.escuela.gestionacademica.dto.CursosPorProfesorDTO(p.nombre, COUNT(c)) " +
           "FROM Curso c JOIN c.profesor p GROUP BY p.nombre")
    List<CursosPorProfesorDTO> contarCursosPorProfesor();
}
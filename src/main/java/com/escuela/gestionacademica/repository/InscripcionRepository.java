package com.escuela.gestionacademica.repository;

import com.escuela.gestionacademica.dto.EstudiantesPorCicloDTO;
import com.escuela.gestionacademica.dto.PromedioCursoDTO;
import com.escuela.gestionacademica.entity.Inscripcion;
// Importación CORRECTA para Pageable
import org.springframework.data.domain.Pageable; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    // Reporte 2: Calcular nota promedio por curso
    @Query("SELECT new com.escuela.gestionacademica.dto.PromedioCursoDTO(c.nombreCurso, AVG(i.notaFinal)) " +
           "FROM Inscripcion i JOIN i.curso c GROUP BY c.nombreCurso")
    List<PromedioCursoDTO> calcularPromedioNotaPorCurso();

    // Reporte 3: Contar estudiantes por ciclo
    @Query("SELECT new com.escuela.gestionacademica.dto.EstudiantesPorCicloDTO(i.ciclo, COUNT(DISTINCT i.estudiante.id)) " +
           "FROM Inscripcion i WHERE i.ciclo IS NOT NULL GROUP BY i.ciclo")
    List<EstudiantesPorCicloDTO> contarEstudiantesPorCiclo();

    // Reporte 4: Obtener los 3 cursos con el promedio de nota más alto
    @Query("SELECT new com.escuela.gestionacademica.dto.PromedioCursoDTO(c.nombreCurso, AVG(i.notaFinal)) " +
           "FROM Inscripcion i JOIN i.curso c WHERE i.notaFinal IS NOT NULL GROUP BY c.nombreCurso ORDER BY AVG(i.notaFinal) DESC")
    List<PromedioCursoDTO> findTopCursosPorPromedio(Pageable pageable);
}
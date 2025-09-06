package com.escuela.gestionacademica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    // Endpoint para Reporte 1
    @GetMapping("/cursos-por-profesor")
    public ResponseEntity<Object> getCursosPorProfesor() {
        return ResponseEntity.ok(reporteService.getCursosPorProfesor());
    }

    // Endpoint para Reporte 2
    @GetMapping("/promedio-nota-por-curso")
    public ResponseEntity<Object> getPromedioNotaPorCurso() {
        return ResponseEntity.ok(reporteService.getPromedioNotaPorCurso());
    }

    // Endpoint para Reporte 3
    @GetMapping("/estudiantes-por-ciclo")
    public ResponseEntity<Object> getEstudiantesPorCiclo() {
        return ResponseEntity.ok(reporteService.getEstudiantesPorCiclo());
    }

    // Endpoint para Reporte 4
    @GetMapping("/top-3-cursos-promedio")
    public ResponseEntity<Object> getTop3Cursos() {
        return ResponseEntity.ok(reporteService.getTop3CursosConMejorPromedio());
    }
}
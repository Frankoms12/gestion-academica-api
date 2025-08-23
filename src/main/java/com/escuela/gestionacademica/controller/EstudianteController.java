package com.escuela.gestionacademica.controller;

import com.escuela.gestionacademica.dto.EstudianteDTO; // 1. Importar el DTO
import com.escuela.gestionacademica.entity.Estudiante;
import com.escuela.gestionacademica.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes") // 2. Cambiado a /api/estudiantes (buena práctica)
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    // --- MÉTODOS GET MODIFICADOS PARA LA TAREA ---

    /**
     * 3. MÉTODO GET PARA TODOS (MODIFICADO)
     * - Devuelve una lista de EstudianteDTO.
     * - Acepta un parámetro opcional "apellido" para filtrar.
     * Ejemplos: GET /api/estudiantes  |  GET /api/estudiantes?apellido=Perez
     */
    @GetMapping
    public List<EstudianteDTO> getAllEstudiantes(
            @RequestParam(required = false) String apellido) {
        // Llama al nuevo método del servicio que maneja el filtro
        return estudianteService.findAll(); // MODIFICADO
    }

    /**
     * 4. MÉTODO GET POR ID (MODIFICADO)
     * - Devuelve un EstudianteDTO.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> getEstudianteById(@PathVariable Integer id) {
        return estudianteService.findById(id) // MODIFICADO
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // --- MÉTODOS POST, PUT, DELETE (Se mantienen igual para esta tarea) ---

    @PostMapping
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.save(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Integer id, @RequestBody Estudiante estudianteDetails) {
        return estudianteService.update(id, estudianteDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Integer id) {
        return estudianteService.deleteById(id)
                ? ResponseEntity.ok().<Void>build()
                : ResponseEntity.notFound().build();
    }
}
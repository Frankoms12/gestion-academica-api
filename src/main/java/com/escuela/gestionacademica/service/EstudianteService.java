package com.escuela.gestionacademica.service;

import com.escuela.gestionacademica.dto.EstudianteDTO; // 1. Importar el DTO
import com.escuela.gestionacademica.entity.Estudiante;
import com.escuela.gestionacademica.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    // 2. MODIFICADO: Ahora devuelve una lista de DTOs
    public List<EstudianteDTO> findAll() {
        return estudianteRepository.findAll()
                .stream()
                .map(this::convertirAEstudianteDTO) // Usa el método conversor
                .collect(Collectors.toList());
    }

    // 3. MODIFICADO: Ahora devuelve un Optional de DTO
    public Optional<EstudianteDTO> findById(Integer id) {
        return estudianteRepository.findById(id)
                .map(this::convertirAEstudianteDTO); // Convierte el resultado si existe
    }

    // Los métodos save, update y delete no necesitan devolver DTOs para esta tarea
    // ya que la tarea se enfoca en los endpoints GET (consulta).
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public Optional<Estudiante> update(Integer id, Estudiante estudianteDetails) {
        return estudianteRepository.findById(id).map(estudiante -> {
            estudiante.setNombre(estudianteDetails.getNombre());
            estudiante.setApellido(estudianteDetails.getApellido());
            estudiante.setEmail(estudianteDetails.getEmail());
            estudiante.setFechaNacimiento(estudianteDetails.getFechaNacimiento());
            return estudianteRepository.save(estudiante);
        });
    }

    public boolean deleteById(Integer id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            return true;
        }
        return false;
    }


    /**
     * 4. NUEVO: Método privado para la lógica de conversión.
     * Convierte una entidad Estudiante a un EstudianteDTO.
     */
    private EstudianteDTO convertirAEstudianteDTO(Estudiante estudiante) {
        String nombreCompleto = estudiante.getNombre() + " " + estudiante.getApellido();

        // Conversión de java.util.Date a java.time.LocalDate para calcular la edad
        LocalDate fechaNac = estudiante.getFechaNacimiento().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        int edad = Period.between(fechaNac, LocalDate.now()).getYears();

        return new EstudianteDTO(
            estudiante.getId(),
            nombreCompleto,
            estudiante.getEmail(),
            edad
        );
    }
}
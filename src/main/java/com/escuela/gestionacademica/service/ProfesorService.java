package com.escuela.gestionacademica.service;

import com.escuela.gestionacademica.entity.Profesor;
import com.escuela.gestionacademica.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> findById(Integer id) {
        return profesorRepository.findById(id);
    }

    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public Optional<Profesor> update(Integer id, Profesor profesorDetails) {
        return profesorRepository.findById(id).map(profesor -> {
            profesor.setNombre(profesorDetails.getNombre());
            profesor.setApellido(profesorDetails.getApellido());
            profesor.setEmail(profesorDetails.getEmail());
            return profesorRepository.save(profesor);
        });
    }

    public boolean deleteById(Integer id) {
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
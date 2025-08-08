package com.escuela.gestionacademica.service;

import com.escuela.gestionacademica.entity.Curso;
import com.escuela.gestionacademica.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Optional<Curso> update(Integer id, Curso cursoDetails) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNombreCurso(cursoDetails.getNombreCurso());
            curso.setDescripcion(cursoDetails.getDescripcion());
            return cursoRepository.save(curso);
        });
    }

    public boolean deleteById(Integer id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

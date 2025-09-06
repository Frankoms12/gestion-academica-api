package com.escuela.gestionacademica.service;

import com.escuela.gestionacademica.dto.CursosPorProfesorDTO;
import com.escuela.gestionacademica.dto.EstudiantesPorCicloDTO;
import com.escuela.gestionacademica.dto.PromedioCursoDTO;
import com.escuela.gestionacademica.repository.CursoRepository;
import com.escuela.gestionacademica.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscripcionRepository inscripcionRepository;

    public List<CursosPorProfesorDTO> getCursosPorProfesor() {
        return cursoRepository.contarCursosPorProfesor();
    }

    public List<PromedioCursoDTO> getPromedioNotaPorCurso() {
        return inscripcionRepository.calcularPromedioNotaPorCurso();
    }

    public List<EstudiantesPorCicloDTO> getEstudiantesPorCiclo() {
        return inscripcionRepository.contarEstudiantesPorCiclo();
    }

    /**
     * @return
     */
    public List<PromedioCursoDTO> getTop3CursosConMejorPromedio() {
        // Usamos Pageable para limitar los resultados a los primeros 3
        Pageable topTres = PageRequest.of(0, 3);
        return inscripcionRepository.findTopCursosPorPromedio(topTres);
    }
}
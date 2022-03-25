/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ito.tecnm.oaxaca.examenunidad1.service;

import edu.ito.tecnm.oaxaca.examenunidad1.model.AlumnoModel;
import edu.ito.tecnm.oaxaca.examenunidad1.repository.AlumnoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jester
 */
@Service
public class AlumnoService {
    
@Autowired
    private AlumnoRepository alumnoRepository;

    public AlumnoModel createAlumno(AlumnoModel alumno) {
        return alumnoRepository.save(alumno);
    }

    public List getAlumnos() {
        return alumnoRepository.findAll();
    }

    public Optional<AlumnoModel> getAlumno(String numControl) {
        return alumnoRepository.findByNumControl(numControl);
    }

    public void updateAlumno(AlumnoModel alumnoModel, Integer idAlumno) {
        alumnoModel.setIdAlumno(idAlumno);
        alumnoRepository.save(alumnoModel);
    }

    public void deleteAlumno(Integer idAlumno) {
        alumnoRepository.deleteById(idAlumno);
    }
}

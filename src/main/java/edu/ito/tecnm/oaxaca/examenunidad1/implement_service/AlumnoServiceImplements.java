package edu.ito.tecnm.oaxaca.examenunidad1.implement_service;

import edu.ito.tecnm.oaxaca.examenunidad1.model.AlumnoModel;
import edu.ito.tecnm.oaxaca.examenunidad1.repository.AlumnoRepository;
import edu.ito.tecnm.oaxaca.examenunidad1.service.AlumnoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jester
 */
@Service
public class AlumnoServiceImplements implements AlumnoService{
    
    
    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public void createAlumno(AlumnoModel alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public List getAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public AlumnoModel getAlumno(String numControl) {
        return alumnoRepository.findByNumControl(numControl);
    }

    @Override
    public void updateAlumno(AlumnoModel alumnoModel, Integer idAlumno) {
        alumnoModel.setIdAlumno(idAlumno);
        alumnoRepository.save(alumnoModel);
    }

    @Override
    public void deleteAlumno(Integer idAlumno) {
        alumnoRepository.deleteById(idAlumno);
    }
}

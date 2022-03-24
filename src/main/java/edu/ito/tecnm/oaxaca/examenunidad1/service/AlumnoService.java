/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ito.tecnm.oaxaca.examenunidad1.service;

import edu.ito.tecnm.oaxaca.examenunidad1.model.AlumnoModel;
import java.util.List;

/**
 *
 * @author Jester
 */
public interface AlumnoService {
    
    public void createAlumno(AlumnoModel alumno);
    
    public List getAlumnos();
    
    public AlumnoModel getAlumno(String numControl);
    
    public void updateAlumno(AlumnoModel alumnoModel, Integer idAlumno);
    
    public void deleteAlumno(Integer idAlumno);
}

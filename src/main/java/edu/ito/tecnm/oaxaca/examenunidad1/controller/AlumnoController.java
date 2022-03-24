/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ito.tecnm.oaxaca.examenunidad1.controller;

import edu.ito.tecnm.oaxaca.examenunidad1.model.AlumnoModel;
import edu.ito.tecnm.oaxaca.examenunidad1.service.AlumnoService;
import edu.ito.tecnm.oaxaca.examenunidad1.utils.CustomResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jester
 */
@RestController
@RequestMapping("/api/v1/ica")
public class AlumnoController {
    
    @Autowired
    private AlumnoService alumnoService;
    
    @PostMapping("/create")
    public CustomResponse createAlumno(@RequestBody AlumnoModel alumno){
    
        CustomResponse customResponse = new CustomResponse();
        alumnoService.createAlumno(alumno);
        
        return customResponse;
    }
    /*
    @PostMapping("/add")
    public ResponseEntity<Map<String,String>> getICA(@ModelAttribute AlumnoModel alumno){
        
        alumnoService.createAlumno(alumno);
    
        double ICA = alumno.getMedidaCintura() / alumno.getMedidaAltura();
        
        String niveles[] = {"Obesidad mórbida", "Sobrepeso elevado", "Sobrepeso",
                "Peso normal", "Delgadez leve", "Delgadez severa"};
        double hombre[] = {0.63, 0.58, 0.53, 0.43, 0.35, 0};
        double mujer[] = {0.58, 0.54, 0.49, 0.42, 0.35, 0};
        String resultado = "";
        
        double indices[];
        
        if(alumno.getGenero() == "H"){
            indices = hombre;
        }else{
        
            indices = mujer;
        }
        for(int i=0; i< niveles.length;i++){
            if (ICA>indices[i]){
                resultado = niveles[i];
                break;
            }}
        
        HashMap<String,String> map = new HashMap<>();
        map.put("ICA", String.valueOf(ICA));
        map.put("resultado", resultado);
        map.put("status", "OK");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }*/
    
    @GetMapping("/{numControl}")
    public CustomResponse getAlumno(@PathVariable String numControl){
    
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(alumnoService.getAlumno(numControl));
        return customResponse;
    }
    
    @GetMapping("/show")
    public CustomResponse getAlumnos(){
    
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(alumnoService.getAlumnos());
        return customResponse;
    }
    
    @PutMapping("/{idAlumno}")
    public CustomResponse updateAlumno(@RequestBody AlumnoModel alumno,@PathVariable Integer idAlumno){
        CustomResponse customResponse = new CustomResponse();
        alumnoService.updateAlumno(alumno, idAlumno);
        return customResponse;
    }
    
    @DeleteMapping("/{idAlumno}")
    public CustomResponse deleteAlumno(@PathVariable Integer idAlumno){
        CustomResponse customResponse = new CustomResponse();
        alumnoService.deleteAlumno(idAlumno);
        return customResponse;
    }
}

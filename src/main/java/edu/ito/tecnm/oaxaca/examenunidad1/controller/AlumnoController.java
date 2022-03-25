package edu.ito.tecnm.oaxaca.examenunidad1.controller;

import edu.ito.tecnm.oaxaca.examenunidad1.model.AlumnoModel;
import edu.ito.tecnm.oaxaca.examenunidad1.repository.AlumnoRepository;
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
    
    //@Autowired
    private final AlumnoService alumnoService;
    
    @Autowired
    public AlumnoController(AlumnoService alumnoService){
    
        this.alumnoService = alumnoService;
    }
    
    @PostMapping("/create")
    public ResponseEntity<Map<String,String>> createAlumno(@RequestBody AlumnoModel alumno){
        
        //--------------FLUJO ALTERNATIVO-------------------
        AlumnoModel al;
        try{

            al = alumnoService.getAlumno(alumno.getNumControl())
                    .orElseThrow(() -> new IllegalStateException("ERROR"));
            
            if(al.getGenero()==null || al.getGenero().equals("")){
                
                if(alumno.getGenero()==null || alumno.getGenero().equals("")){
                
                HashMap<String, String> mapError = new HashMap<>();
                mapError.put("ERROR", "No hay género");
                return new ResponseEntity<>(mapError,HttpStatus.BAD_REQUEST);
                
                }else{
                
                    al.setGenero(alumno.getGenero());
                }
                
            //Testing
            
           if(al.getMedidaCintura()== null || al.getMedidaCintura()== 0){
        
                if(alumno.getMedidaCintura()== null || alumno.getMedidaCintura()== 0){
                
                HashMap<String, String> mapError = new HashMap<>();
                mapError.put("ERROR", "No hay medida de la cintura");
                return new ResponseEntity<>(mapError,HttpStatus.BAD_REQUEST);
            }else{
            
                al.setMedidaCintura(alumno.getMedidaCintura());//Asignamos la altura recolectada del alumno que se le paso en la firma del método
            }
        }
           
            if(al.getMedidaAltura() == null || al.getMedidaAltura() == 0){
            
            if(alumno.getMedidaAltura() == null || alumno.getMedidaAltura() == 0){
                
                HashMap<String, String> mapError = new HashMap<>();
                mapError.put("ERROR", "No hay altura");
                return new ResponseEntity<>(mapError,HttpStatus.BAD_REQUEST);
            }else{
            
                al.setMedidaAltura(alumno.getMedidaAltura());//Asignamos la altura recolectada del alumno que se le paso en la firma del método
            }

        }
                
        }
           al = alumnoService.createAlumno(al); //Guardamos el registro
           
        }catch(IllegalStateException e){
            
        /*OTHER TESTING 
            if(alumno == null){
            
                HashMap<String, String> map = new HashMap<>();
                map.put("ERROR", "VALORES NULOS");
                return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
        */
        
            al = alumnoService.createAlumno(alumno);
        }
        
        //--------------FLUJO NORMAL------------------------
        
        //al = alumnoService.createAlumno(alumno);
        
        //----------------VALIDACIONES---------------------
        
        if(al.getGenero()==null || al.getGenero().equals("")){
        
                HashMap<String, String> mapError = new HashMap<>();
                mapError.put("ERROR", "No hay género");
                return new ResponseEntity<>(mapError,HttpStatus.BAD_REQUEST);
        }
        
        if(al.getMedidaCintura()== null || al.getMedidaCintura()== 0){ //al.getMedidaCintura()== 0 || al.getMedidaCintura()==null
        
                HashMap<String, String> mapError = new HashMap<>();
                mapError.put("ERROR", "No hay medida de la cintura");
                return new ResponseEntity<>(mapError,HttpStatus.BAD_REQUEST);
        }
        
        if(al.getMedidaAltura() == null || al.getMedidaAltura() == 0){ //al.getMedidaAltura() == 0 || al.getMedidaAltura() ==null
        
                HashMap<String, String> mapError = new HashMap<>();
                mapError.put("ERROR", "No hay altura");
                return new ResponseEntity<>(mapError,HttpStatus.BAD_REQUEST);
        }
        
        double ICA = (double)al.getMedidaCintura() / al.getMedidaAltura();
        
        String niveles[] = {"Obesidad mórbida", "Sobrepeso elevado", "Sobrepeso",
                "Peso normal", "Delgadez leve", "Delgadez severa"};
        
        double hombre[] = {0.63, 0.58, 0.53, 0.43, 0.35, 0};
        double mujer[] = {0.58, 0.54, 0.49, 0.42, 0.35, 0};
        String resultado = "";
        
        double indices[];
        
        if(al.getGenero().equals("H")){
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
        map.put("Nivel", resultado);
        map.put("status", "OK");
        return new ResponseEntity<>(map, HttpStatus.OK);

    }
    /*
    @PostMapping("/add")
    public ResponseEntity<Map<String,String>> getICA(@ModelAttribute AlumnoModel alumno){
        
        //alumnoService.createAlumno(alumno);
        //alumno = alumnoService.getAlumno(alumno.getNumControl());
        
        String niveles[] = {"Obesidad mórbida", "Sobrepeso elevado", "Sobrepeso",
                "Peso normal", "Delgadez leve", "Delgadez severa"};
        int hombre[] = {63, 58, 53, 43, 35, 0};
        int mujer[] = {58, 54, 49, 42, 35, 0};
        String resultado = "";
        AlumnoModel al;
        
        try{
            al = alumnoService.getAlumno(alumno.getNumControl())
                   .orElseThrow(() -> new IllegalStateException("ERROR"));
            if(alumno.getMedidaAltura() != null && alumno.getMedidaAltura() !=0)
                al.setMedidaAltura(alumno.getMedidaAltura());
            if(alumno.getMedidaCintura() != null && alumno.getMedidaCintura() != 0)
                al.setMedidaCintura(alumno.getMedidaCintura());
            alumno = alumnoService.createAlumno(al);
            
            
        }catch(IllegalStateException e){}
        
        if(alumno.getMedidaCintura()==0 || alumno.getMedidaCintura()==null){
        
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        
        int ICA = alumno.getMedidaCintura() / alumno.getMedidaAltura();
        
        int indices[];
        
        if(alumno.getGenero().equals("H")){
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
    }
    */

    
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

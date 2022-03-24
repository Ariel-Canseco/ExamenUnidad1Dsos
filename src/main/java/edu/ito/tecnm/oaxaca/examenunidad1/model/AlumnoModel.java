package edu.ito.tecnm.oaxaca.examenunidad1.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jester
 */
@Entity
@Table(name="alumno")
public class AlumnoModel implements Serializable{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAlumno;
    private String numControl;
    private String genero;
    private Integer medidaCintura;
    private Integer medidaAltura;

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getMedidaCintura() {
        return medidaCintura;
    }

    public void setMedidaCintura(Integer medidaCintura) {
        this.medidaCintura = medidaCintura;
    }

    public Integer getMedidaAltura() {
        return medidaAltura;
    }

    public void setMedidaAltura(Integer medidaAltura) {
        this.medidaAltura = medidaAltura;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", numControl=" + numControl + ", genero=" + genero + ", medidaCintura=" + medidaCintura + ", medidaAltura=" + medidaAltura + '}';
    }
    
    
}

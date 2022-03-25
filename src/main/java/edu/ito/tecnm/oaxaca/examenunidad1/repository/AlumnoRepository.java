package edu.ito.tecnm.oaxaca.examenunidad1.repository;

import edu.ito.tecnm.oaxaca.examenunidad1.model.AlumnoModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jester
 */
@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoModel, Integer>{
    public Optional<AlumnoModel> findByNumControl(String numControl);
}

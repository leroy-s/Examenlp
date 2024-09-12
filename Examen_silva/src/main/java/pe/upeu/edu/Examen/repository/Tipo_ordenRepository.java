package pe.upeu.edu.Examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upeu.edu.Examen.entity.Tipo_orden;

@Repository
public interface Tipo_ordenRepository  extends JpaRepository<Tipo_orden, Long>{

}

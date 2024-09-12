package pe.upeu.edu.Examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upeu.edu.Examen.entity.Forma_pago;

@Repository
public interface Forma_pagoRepository  extends JpaRepository<Forma_pago, Long>{

}

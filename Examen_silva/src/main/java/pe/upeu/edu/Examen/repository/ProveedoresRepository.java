package pe.upeu.edu.Examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upeu.edu.Examen.entity.Proveedores;

@Repository
public interface ProveedoresRepository  extends JpaRepository<Proveedores, Long>{

}

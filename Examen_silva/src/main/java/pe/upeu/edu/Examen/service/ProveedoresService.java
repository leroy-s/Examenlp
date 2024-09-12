package pe.upeu.edu.Examen.service;

import java.util.List;
import java.util.Optional;

import pe.upeu.edu.Examen.entity.Proveedores;

public interface ProveedoresService {
	Proveedores create(Proveedores a);
	Proveedores update(Proveedores a);
	void delete(Long id);
	Optional<Proveedores> read(Long id);
	List<Proveedores> readAll();
}

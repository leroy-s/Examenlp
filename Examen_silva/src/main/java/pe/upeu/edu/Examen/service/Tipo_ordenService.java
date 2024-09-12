package pe.upeu.edu.Examen.service;

import java.util.List;
import java.util.Optional;

import pe.upeu.edu.Examen.entity.Tipo_orden;

public interface Tipo_ordenService {
	Tipo_orden create(Tipo_orden a);
	Tipo_orden update(Tipo_orden a);
	void delete(Long id);
	Optional<Tipo_orden> read(Long id);
	List<Tipo_orden> readAll();
}

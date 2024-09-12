package pe.upeu.edu.Examen.service;

import java.util.List;
import java.util.Optional;

import pe.upeu.edu.Examen.entity.Ordenes;

public interface OrdenesService {
	Ordenes create(Ordenes a);
	Ordenes update(Ordenes a);
	void delete(Long id);
	Optional<Ordenes> read(Long id);
	List<Ordenes> readAll();
}

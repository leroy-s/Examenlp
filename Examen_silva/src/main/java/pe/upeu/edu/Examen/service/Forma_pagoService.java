package pe.upeu.edu.Examen.service;

import java.util.List;
import java.util.Optional;

import pe.upeu.edu.Examen.entity.Forma_pago;

public interface Forma_pagoService {
	Forma_pago create(Forma_pago a);
	Forma_pago update(Forma_pago a);
	void delete(Long id);
	Optional<Forma_pago> read(Long id);
	List<Forma_pago> readAll();
}

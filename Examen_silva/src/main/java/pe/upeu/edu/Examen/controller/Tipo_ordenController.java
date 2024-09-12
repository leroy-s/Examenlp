package pe.upeu.edu.Examen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import pe.upeu.edu.Examen.entity.Tipo_orden;
import pe.upeu.edu.Examen.service.Tipo_ordenService;

@RestController
@RequestMapping("/api/tipo_orden")
public class Tipo_ordenController {

    @Autowired
    private Tipo_ordenService service;

    @GetMapping
    public ResponseEntity<List<Tipo_orden>> readAll() {
        try {
            List<Tipo_orden> tipoOrdenes = service.readAll();
            if (tipoOrdenes.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(tipoOrdenes, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Tipo_orden> crear(@Valid @RequestBody Tipo_orden tipoOrden) {
        try {
            Tipo_orden t = service.create(tipoOrden);
            return new ResponseEntity<>(t, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo_orden> getTipo_ordenId(@PathVariable("id") Long id) {
        try {
            Tipo_orden t = service.read(id).get();
            return new ResponseEntity<>(t, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tipo_orden> delTipo_orden(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipo_orden> updateTipo_orden(@PathVariable("id") Long id, @Valid @RequestBody Tipo_orden tipoOrden) {
        Optional<Tipo_orden> t = service.read(id);
        if (t.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(service.update(tipoOrden), HttpStatus.OK);
        }
    }
}
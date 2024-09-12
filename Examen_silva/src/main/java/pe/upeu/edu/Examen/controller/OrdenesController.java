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
import pe.upeu.edu.Examen.entity.Ordenes;
import pe.upeu.edu.Examen.service.OrdenesService;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenesController {

    @Autowired
    private OrdenesService service;

    @GetMapping
    public ResponseEntity<List<Ordenes>> readAll() {
        try {
            List<Ordenes> ordenes = service.readAll();
            if (ordenes.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(ordenes, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Ordenes> crear(@Valid @RequestBody Ordenes orden) {
        try {
            Ordenes o = service.create(orden);
            return new ResponseEntity<>(o, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ordenes> getOrdenesId(@PathVariable("id") Long id) {
        try {
            Ordenes o = service.read(id).get();
            return new ResponseEntity<>(o, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ordenes> delOrdenes(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ordenes> updateOrdenes(@PathVariable("id") Long id, @Valid @RequestBody Ordenes orden) {
        Optional<Ordenes> o = service.read(id);
        if (o.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(service.update(orden), HttpStatus.OK);
        }
    }
}
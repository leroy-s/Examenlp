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
import pe.upeu.edu.Examen.entity.Proveedores;
import pe.upeu.edu.Examen.service.ProveedoresService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresService service;

    @GetMapping
    public ResponseEntity<List<Proveedores>> readAll() {
        try {
            List<Proveedores> proveedores = service.readAll();
            if (proveedores.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(proveedores, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Proveedores> crear(@Valid @RequestBody Proveedores proveedor) {
        try {
            Proveedores p = service.create(proveedor);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
        public ResponseEntity<Proveedores> getProveedoresId(@PathVariable("id") Long id) {
            try {
                Proveedores p = service.read(id).get();
                return new ResponseEntity<>(p, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Proveedores> delProveedores(@PathVariable("id") Long id) {
            try {
                service.delete(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<Proveedores> updateProveedores(@PathVariable("id") Long id, @Valid @RequestBody Proveedores proveedor) {
            Optional<Proveedores> p = service.read(id);
            if (p.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(service.update(proveedor), HttpStatus.OK);
            }
        }
    }
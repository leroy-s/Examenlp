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
import pe.upeu.edu.Examen.entity.Forma_pago;
import pe.upeu.edu.Examen.service.Forma_pagoService;

@RestController
@RequestMapping("/api/forma_pago")
public class Forma_pagoController {
    
    @Autowired
    private Forma_pagoService service;
    
    @GetMapping
    public ResponseEntity<List<Forma_pago>> readAll() {
        try {
            List<Forma_pago> formaPago = service.readAll();
            if (formaPago.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(formaPago, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping
    public ResponseEntity<Forma_pago> crear(@Valid @RequestBody Forma_pago formaPago) {
        try {
            Forma_pago f = service.create(formaPago);
            return new ResponseEntity<>(f, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Forma_pago> getFormaPagoId(@PathVariable("id") Long id) {
        try {
            Forma_pago f = service.read(id).get();
            return new ResponseEntity<>(f, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Forma_pago> delFormaPago(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Forma_pago> updateFormaPago(@PathVariable("id") Long id, @Valid @RequestBody Forma_pago formaPago) {
        Optional<Forma_pago> f = service.read(id);
        if (f.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(service.update(formaPago), HttpStatus.OK);
        }
    }
}
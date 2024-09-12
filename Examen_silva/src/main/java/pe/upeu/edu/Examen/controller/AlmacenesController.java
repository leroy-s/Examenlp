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
import pe.upeu.edu.Examen.entity.Almacenes;
import pe.upeu.edu.Examen.service.AlmacenesService;
@RestController
@RequestMapping("/api/Almacenes")
public class AlmacenesController {
		@Autowired
		private AlmacenesService service;
		
		@GetMapping
		public ResponseEntity<List<Almacenes>> readAll() {
			try {
				List<Almacenes> almacenes = service.readAll();
				if (almacenes.isEmpty()) {
					return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
				} else {
					return new ResponseEntity<>(almacenes, HttpStatus.OK);
				}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PostMapping
		public ResponseEntity<Almacenes> crear(@Valid @RequestBody Almacenes al) {
			try {
				Almacenes a = service.create(al);
				return new ResponseEntity<>(a, HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Almacenes> getAlmacenesid(@PathVariable("id") Long id) {
		    try {
		        Optional<Almacenes> a = service.read(id);
		        
		        if (a.isPresent()) {
		            return new ResponseEntity<>(a.get(), HttpStatus.OK);  
		        } else {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		        }
		    } catch (Exception e) {
		        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);  
		    }
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Almacenes> delAlmacenes(@PathVariable("id") Long id) {
			try {
				service.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Almacenes> updateAlmacenes(@PathVariable("id") Long id, @Valid @RequestBody Almacenes al) {
			Optional<Almacenes> a = service.read(id);
			if (a.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(service.update(al), HttpStatus.OK);
				
			}
		}


}

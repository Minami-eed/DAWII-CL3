package com.cibertec.DAW2CL3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.DAW2CL3.model.Docente;
import com.cibertec.DAW2CL3.service.DocenteService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/docentes")
public class DocenteController {
    @Autowired
    private DocenteService service;

    // LISTAR DOCENTES
    @GetMapping
    public ResponseEntity<?> listarDocente() {
        List<Docente> docentes = service.listarDocente();
        return new ResponseEntity<>(docentes, docentes.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    // OBTENER DOCENTE
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> obtenerDocente(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.obtenerDocente(id), HttpStatus.OK);
    }

    // REGISTRAR DOCENTE
    @PostMapping
    public ResponseEntity<?> registrarDocente(@RequestBody Docente docente) {
        Docente newDocente = service.registrarDocente(docente);
        return new ResponseEntity<Docente>(newDocente, HttpStatus.OK);
    }

    // MODIFICAR DOCENTE
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> modificarDocente(@PathVariable("id") Integer id, @RequestBody Docente docente) {
        docente.setIddocente(id);
        Docente newDocente = service.modificarDocente(id, docente);
        return new ResponseEntity<Docente>(newDocente, HttpStatus.OK);
    }

    // ELIMINAR DOCENTE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> eliminarDocente(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.eliminarDocente(id), HttpStatus.OK);
    }
}

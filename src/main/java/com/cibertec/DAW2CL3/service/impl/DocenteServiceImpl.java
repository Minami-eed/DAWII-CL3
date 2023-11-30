package com.cibertec.DAW2CL3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.DAW2CL3.model.Docente;
import com.cibertec.DAW2CL3.repo.DocenteRepository;
import com.cibertec.DAW2CL3.service.DocenteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DocenteServiceImpl implements DocenteService{
    
    @Autowired
    private DocenteRepository repository;

    @Override
    public List<Docente> listarDocente() {
        return repository.findAll();
    }

    @Override
    public Docente obtenerDocente(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Docente registrarDocente(Docente docente) {
        return repository.save(docente);
    }

    @Override
    public Docente modificarDocente(Integer id, Docente docente) {
        Docente oldDocente = repository.findById(id).orElse(null);
        if (oldDocente != null) {
            oldDocente.setNombre(docente.getNombre());
            oldDocente.setDni(docente.getDni());
            oldDocente.setFechaNacimiento(docente.getFechaNacimiento());
            oldDocente.setSueldo(docente.getSueldo());
            oldDocente.setEmail(docente.getEmail());
            oldDocente.setSexo(docente.getSexo());
            oldDocente.setCategoria(docente.getCategoria());

            return repository.save(oldDocente);
        } else {
            return null;
        }
    }

    @Override
    public String eliminarDocente(Integer id) {
        repository.deleteById(id);
        return "Docente Eliminado";
    }
    
}

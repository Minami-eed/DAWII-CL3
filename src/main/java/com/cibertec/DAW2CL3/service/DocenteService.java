package com.cibertec.DAW2CL3.service;

import java.util.List;

import com.cibertec.DAW2CL3.model.Docente;

public interface DocenteService {
    public List<Docente> listarDocente();

    public Docente obtenerDocente(Integer id);

    public Docente registrarDocente(Docente docente);

    public Docente modificarDocente(Integer id, Docente docente);

    public String eliminarDocente(Integer id);
}

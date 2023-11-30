package com.cibertec.DAW2CL3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.DAW2CL3.model.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {

}

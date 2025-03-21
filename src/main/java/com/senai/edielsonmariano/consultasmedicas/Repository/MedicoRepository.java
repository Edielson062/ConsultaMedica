package com.senai.edielsonmariano.consultasmedicas.Repository;

import com.senai.edielsonmariano.consultasmedicas.entidades.Medico;
import com.senai.edielsonmariano.consultasmedicas.entidades.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}

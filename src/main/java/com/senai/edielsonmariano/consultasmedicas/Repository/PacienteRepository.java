package com.senai.edielsonmariano.consultasmedicas.Repository;

import com.senai.edielsonmariano.consultasmedicas.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}

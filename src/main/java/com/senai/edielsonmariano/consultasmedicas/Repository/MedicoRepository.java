package com.senai.edielsonmariano.consultasmedicas.Repository;

import com.senai.edielsonmariano.consultasmedicas.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}

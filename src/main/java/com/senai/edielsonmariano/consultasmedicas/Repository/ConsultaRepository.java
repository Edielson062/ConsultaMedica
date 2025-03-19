package com.senai.edielsonmariano.consultasmedicas.Repository;

import com.senai.edielsonmariano.consultasmedicas.entidades.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}

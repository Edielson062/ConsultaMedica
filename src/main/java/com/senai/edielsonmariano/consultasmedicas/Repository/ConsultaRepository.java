package com.senai.edielsonmariano.consultasmedicas.Repository;

import com.senai.edielsonmariano.consultasmedicas.entidades.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    @Query("SELECT con FROM Consulta con WHERE con.paciente.nomePaciente LIKE CONCAT('%', :nomePaciente, '%')")
    List<Consulta> buscarPaciente(@Param("nomePaciente") String nomePaciente);

    @Query("SELECT c FROM Consulta c WHERE c.paciente.idPaciente = :idPaciente AND c.horaConsulta = :horaConsulta AND c.dataConsulta = :dataConsulta")
    List<Consulta> findByPacienteAndHorario(@Param("idPaciente") Integer idPaciente, @Param("horaConsulta") String horaConsulta, @Param("dataConsulta") String dataConsulta);

}

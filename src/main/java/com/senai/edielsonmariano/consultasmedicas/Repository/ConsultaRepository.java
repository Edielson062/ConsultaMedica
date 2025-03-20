package com.senai.edielsonmariano.consultasmedicas.Repository;

import com.senai.edielsonmariano.consultasmedicas.entidades.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    @Query("SELECT con FROM Consulta con WHERE con.paciente.nomePaciente LIKE CONCAT('%', :nomePaciente, '%')")
    List<Consulta> buscarPaciente(@Param("nomePaciente") String nomePaciente);

//    @Query("SELECT con FROM Consulta con WHERE FUNCTION('DATE_FORMAT', con.dataConsulta, '%Y-%m-%d') LIKE :dataConsulta")
//    List<Consulta> buscarData(@Param("dataConsulta") String dataConsulta);
//
//    @Query("SELECT con FROM Consulta con WHERE con.medico.nomeMedico LIKE CONCAT('%', :nomeMedico, '%')")
//    List<Consulta> buscarMedico(@Param("nomeMedico") String nomeMedico);

}

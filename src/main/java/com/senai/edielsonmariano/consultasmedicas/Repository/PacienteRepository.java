package com.senai.edielsonmariano.consultasmedicas.Repository;

import com.senai.edielsonmariano.consultasmedicas.entidades.Paciente;
import com.senai.edielsonmariano.consultasmedicas.entidades.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
//    @Query("SELECT pa FROM Paciente pa WHERE pa.nomePaciente LIKE CONCAT('%', :nomePaciente, '%')")
//    List<Paciente> buscarNomePaciente(@Param("nomePaciente") String nomePaciente);
//
//    @Query("SELECT pa FROM Paciente pa WHERE pa.cpf LIKE CONCAT('%', :cpf, '%')")
//    List<Paciente> buscarCpfPaciente(@Param("cpf") String cpf);

}

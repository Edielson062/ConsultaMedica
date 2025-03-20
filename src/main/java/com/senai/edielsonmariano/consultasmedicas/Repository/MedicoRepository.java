package com.senai.edielsonmariano.consultasmedicas.Repository;

import com.senai.edielsonmariano.consultasmedicas.entidades.Medico;
import com.senai.edielsonmariano.consultasmedicas.entidades.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
//
//    @Query("SELECT me FROM Medico me WHERE me.nomeMedico LIKE CONCAT('%', :nomeMedico, '%')")
//    List<Medico> buscarNomeMedico(@Param("nomeMedico") String nomeMedico);
//
//    @Query("SELECT me FROM Medico me WHERE me.crm = :crmMedico")
//    List<Medico> buscarCrmMedico(@Param("crmMedico") Integer crmMedico);
//
//    @Query("SELECT me FROM Medico me WHERE me.especialidade LIKE CONCAT('%', :especialidadeMedico, '%')")
//    List<Medico> buscarEspecialidadeMedico(@Param("especialidadeMedico") String especialidadeMedico);
}

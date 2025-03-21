package com.senai.edielsonmariano.consultasmedicas.Service;

import com.senai.edielsonmariano.consultasmedicas.Repository.ConsultaRepository;
import com.senai.edielsonmariano.consultasmedicas.entidades.Consulta;
import com.senai.edielsonmariano.consultasmedicas.entidades.Medico;
import com.senai.edielsonmariano.consultasmedicas.entidades.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> listarConsultas(){
        return consultaRepository.findAll();
    }

    public Consulta buscaConsulta(int id){
        return consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrado"));
    }

    public List<Consulta> buscaConsultaPaciente(String nome){
        return consultaRepository.buscarPaciente(nome);
    }


    public Consulta salvaConsulta(Consulta consulta) {

        List<Consulta> consultasExistentes = consultaRepository.findByPacienteAndHorario(
                consulta.getPaciente().getIdPaciente(),
                consulta.getHoraConsulta(),
                consulta.getDataConsulta()
        );
        if (!consultasExistentes.isEmpty()) {
            throw new RuntimeException("O paciente já possui uma consulta nesse horário.");
        }
        Paciente paciente = consulta.getPaciente();

        if (paciente.getConsultas() != null) {
            paciente.getConsultas().add(consulta);
        } else {
            List<Consulta> consultas = new ArrayList<>();
            consultas.add(consulta);
            paciente.setConsultas(consultas);
        }
        return consultaRepository.save(consulta);
    }

    public Consulta atualizaConsulta(Consulta consulta){
        return this.salvaConsulta(consulta);
    }

    public void deleteConsulta(int id){
        consultaRepository.deleteById(id);
    }
}

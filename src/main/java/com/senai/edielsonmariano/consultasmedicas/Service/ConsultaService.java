package com.senai.edielsonmariano.consultasmedicas.Service;

import com.senai.edielsonmariano.consultasmedicas.Repository.ConsultaRepository;
import com.senai.edielsonmariano.consultasmedicas.Repository.MedicoRepository;
import com.senai.edielsonmariano.consultasmedicas.Repository.PacienteRepository;
import com.senai.edielsonmariano.consultasmedicas.entidades.Consulta;
import com.senai.edielsonmariano.consultasmedicas.entidades.Medico;
import com.senai.edielsonmariano.consultasmedicas.entidades.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    private PacienteRepository pacienteRepository;
    private MedicoRepository medicoRepository;

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

        Medico medico = consulta.getMedico();
        if (medico.getConsultas() != null) {
            medico.getConsultas().add(consulta);
        } else {
            List<Consulta> consultas = new ArrayList<>();
            consultas.add(consulta);
            medico.setConsultas(consultas);
        }

        return consultaRepository.save(consulta);
    }

    public Consulta atualizaConsulta(Consulta consulta) {
        Optional<Consulta> consultaOpt = consultaRepository.findById(consulta.getIdConsulta());

        if (consultaOpt.isPresent()) {
            Consulta consultaAntiga = consultaOpt.get();

            Paciente pacienteAntigo = consultaAntiga.getPaciente();
            if (pacienteAntigo != null && pacienteAntigo.getConsultas() != null) {
                pacienteAntigo.getConsultas().remove(consultaAntiga);
                pacienteRepository.save(pacienteAntigo);
            }

            Medico medicoAntigo = consultaAntiga.getMedico();
            if (medicoAntigo != null && medicoAntigo.getConsultas() != null) {
                medicoAntigo.getConsultas().remove(consultaAntiga);
                medicoRepository.save(medicoAntigo);
            }
        }

        return this.salvaConsulta(consulta);
    }


    public void deleteConsulta(int id) {
        Optional<Consulta> consultaOpt = consultaRepository.findById(id);

        if (consultaOpt.isPresent()) {
            Consulta consulta = consultaOpt.get();

            Paciente paciente = consulta.getPaciente();
            if (paciente != null && paciente.getConsultas() != null) {
                paciente.getConsultas().remove(consulta);
                pacienteRepository.save(paciente);
            }

            Medico medico = consulta.getMedico();
            if (medico != null && medico.getConsultas() != null) {
                medico.getConsultas().remove(consulta);
                medicoRepository.save(medico);
            }

            consultaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Consulta não encontrada.");
        }
    }
}

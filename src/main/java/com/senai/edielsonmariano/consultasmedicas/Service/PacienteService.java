package com.senai.edielsonmariano.consultasmedicas.Service;

import com.senai.edielsonmariano.consultasmedicas.Repository.PacienteRepository;
import com.senai.edielsonmariano.consultasmedicas.entidades.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listaPaciente() {
        return pacienteRepository.findAll();
    }

    public Paciente buscaPaciente(Integer id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

//    public List<Paciente> buscarNomePaciente(String nome) {
//        return pacienteRepository.buscarNomePaciente(nome);
//    }
//
//    public List<Paciente> busacaCpfPaciente(String cpf) {
//        return pacienteRepository.buscarCpfPaciente(cpf);
//    }


    public Paciente salvaPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizaPaciente(Paciente paciente) {
        return this.salvaPaciente(paciente);
    }

    public void removaPaciente(Integer id) {
        pacienteRepository.deleteById(id);
    }
}

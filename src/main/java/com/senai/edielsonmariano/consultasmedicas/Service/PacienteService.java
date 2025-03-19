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

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Paciente findById(Integer id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

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

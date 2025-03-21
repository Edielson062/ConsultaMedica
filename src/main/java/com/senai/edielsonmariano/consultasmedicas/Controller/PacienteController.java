package com.senai.edielsonmariano.consultasmedicas.Controller;

import com.senai.edielsonmariano.consultasmedicas.Service.PacienteService;
import com.senai.edielsonmariano.consultasmedicas.entidades.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.listaPaciente();
    }

    @GetMapping("/{id}")
    public Paciente buscaPaciente(@PathVariable Integer id) {
        return pacienteService.buscaPaciente(id);
    }

    @PostMapping
    public Paciente cadastrarPaciente(Paciente paciente) {
        return pacienteService.salvaPaciente(paciente);
    }

    @PutMapping
    public Paciente atualizaPaciente(Paciente paciente) {
        return pacienteService.atualizaPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public void removaPaciente(@PathVariable Integer id) {
        this.pacienteService.removaPaciente(id);
    }
}

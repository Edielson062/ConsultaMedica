package com.senai.edielsonmariano.consultasmedicas.Controller;

import com.senai.edielsonmariano.consultasmedicas.Service.MedicoService;
import com.senai.edielsonmariano.consultasmedicas.entidades.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> listaMedicos() {
        return medicoService.listaMedicos();
    }

    @GetMapping("/{id}")
    public Medico buscaMedico(@PathVariable Integer id) {
        return medicoService.buscaMedico(id);
    }

    @PostMapping
    public Medico cadastrarMedico(@RequestBody Medico medico) {
        return medicoService.salvaMedico(medico);
    }

    @PutMapping
    public Medico atualizarMedico(@RequestBody Medico medico) {
        return medicoService.atualizaMedico(medico);
    }

    @DeleteMapping("/{id}")
    public void removerMedico(@PathVariable Integer id) {
        this.medicoService.removaMedico(id);
    }
}

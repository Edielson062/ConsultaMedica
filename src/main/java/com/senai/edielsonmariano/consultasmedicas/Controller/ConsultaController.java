package com.senai.edielsonmariano.consultasmedicas.Controller;


import com.senai.edielsonmariano.consultasmedicas.Service.ConsultaService;
import com.senai.edielsonmariano.consultasmedicas.entidades.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<Consulta> listarConsultas(){
        return consultaService.listarConsultas();
    }

    @GetMapping("/{id}")
    public Consulta buscaConsulta(@PathVariable int id){
        return consultaService.buscaConsulta(id);
    }

    @GetMapping("/paciente/{nomePaciente}")
    public List<Consulta> buscaConsultasPaciente(@PathVariable String nomePaciente){
        return consultaService.buscaConsultaPaciente(nomePaciente);
    }

    @PostMapping
    public Consulta adicionaConsulta(Consulta consulta){
        return consultaService.salvaConsulta(consulta);
    }

    @PutMapping
    public Consulta atualizaConsulta(Consulta consulta){
        return consultaService.atualizaConsulta(consulta);
    }

    @DeleteMapping("/{id}")
    public void deletaConsulta(Integer id){
        this.consultaService.deleteConsulta(id);
    }
}

package com.senai.edielsonmariano.consultasmedicas.Service;

import com.senai.edielsonmariano.consultasmedicas.Repository.ConsultaRepository;
import com.senai.edielsonmariano.consultasmedicas.entidades.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> getAllConsultas(){
        return consultaRepository.findAll();
    }

    public Consulta getConsultaById(int id){
        return consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrado"));
    }

    public Consulta salvaConsulta(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public Consulta atualizaConsulta(Consulta consulta){
        return this.salvaConsulta(consulta);
    }
}

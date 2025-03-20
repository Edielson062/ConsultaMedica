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

    public List<Consulta> listarConsultas(){
        return consultaRepository.findAll();
    }

    public Consulta buscaConsulta(int id){
        return consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrado"));
    }

    public List<Consulta> buscaConsultaPaciente(String nome){
        return consultaRepository.buscarPaciente(nome);
    }
//
//    public List<Consulta> buscaConsultaMedicao(String nome){
//        return consultaRepository.buscarMedico(nome);
//    }
//
//    public List<Consulta> buscaConsultaData(String data){
//        return consultaRepository.buscarData(data);
//    }

    public Consulta salvaConsulta(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public Consulta atualizaConsulta(Consulta consulta){
        return this.salvaConsulta(consulta);
    }

    public void deleteConsulta(int id){
        consultaRepository.deleteById(id);
    }
}

package com.senai.edielsonmariano.consultasmedicas.Service;

import com.senai.edielsonmariano.consultasmedicas.Repository.MedicoRepository;
import com.senai.edielsonmariano.consultasmedicas.entidades.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> listaMedicos() {
        return medicoRepository.findAll();
    }

    public Medico buscaMedico(Integer id) {
        return medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }

    public Medico salvaMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico atualizaMedico(Medico medico) {
        return this.salvaMedico(medico);
    }

    public void removaMedico(Integer id) {
        this.medicoRepository.deleteById(id);
    }

}

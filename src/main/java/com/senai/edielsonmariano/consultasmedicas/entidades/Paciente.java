package com.senai.edielsonmariano.consultasmedicas.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPaciente;

    @Column(name = "nomePaciente", nullable = false, length = 100)
    private String nomePaciente;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "dataNascimento", nullable = false, length = 10)
    private String dataNascimento;

    @Column(name = "telefone", nullable = false, length = 11)
    private String telefone;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "paciente")
    @JsonManagedReference
    private List<Consulta> consultas;


    public Paciente() {
    }

    public Paciente(Integer id, String nomePaciente, String dataNascimento, String cpf, String telefone) {
        this.idPaciente = id;
        this.nomePaciente = nomePaciente;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer id) {
        this.idPaciente = id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}

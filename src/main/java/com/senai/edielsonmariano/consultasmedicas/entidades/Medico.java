package com.senai.edielsonmariano.consultasmedicas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMedico;

    @Column(name = "nomeMedico", nullable = false, length = 100)
    private String nomeMedico;

    @Column(name = "especialidade", nullable = false, length = 100)
    private String especialidade;

    @Column(name = "crm", nullable = false, length = 100)
    private Integer crm;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "medico")
    @JsonManagedReference
    private List<Consulta> consultas;


    public Medico() {
    }

    public Medico(Integer id, String nome, String especialidade, Integer crm) {
        this.idMedico = id;
        this.nomeMedico = nome;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nome) {
        this.nomeMedico = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}

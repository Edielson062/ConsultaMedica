package com.senai.edielsonmariano.consultasmedicas.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idConsulta;

    @Column(name = "dataConsulta", length = 10)
    private String dataConsulta;

    @Column(name = "horaConsulta", length = 10)
    private String horaConsulta;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    @JsonBackReference
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false)
    @JsonBackReference
    private Medico medico;


    public Consulta() {
    }

    public Consulta(String dataConsulta, Integer idConsulta, String horaConsulta, Medico medico, Paciente paciente) {
        this.dataConsulta = dataConsulta;
        this.idConsulta = idConsulta;
        this.horaConsulta = horaConsulta;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}

package com.senai.edielsonmariano.consultasmedicas.entidades;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idConsulta;

    @Column(name = "dataConsulta", nullable = false, length = 10)
    private Date dataConsulta;

    @Column(name = "horaConsulta", nullable = false, length = 10)
    private Time horaConsulta;

    @ManyToOne
    @JoinColumn(name = "medico[idMedico]")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente[idPaciente]")
    private Paciente paciente;

    public Consulta() {
    }

    public Consulta(Date dataConsulta, Integer idConsulta, Time horaConsulta, Medico medico, Paciente paciente) {
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

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Time getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(Time horaConsulta) {
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

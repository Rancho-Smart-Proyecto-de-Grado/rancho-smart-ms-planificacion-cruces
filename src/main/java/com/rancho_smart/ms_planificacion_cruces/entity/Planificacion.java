package com.rancho_smart.ms_planificacion_cruces.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLANIFICACION")
public class Planificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanificacion;

    @Column(name = "ID_CRUCE")
    private Long idCruce;

    @Column(name = "FECHA")
    private LocalDateTime fecha;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "ID_FINCA")
    private Long idFinca;

    public Planificacion() {
    }   

    public Planificacion(Long idCruce, LocalDateTime fecha, Long idUsuario, Long idFinca) {
        this.idCruce = idCruce;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idFinca = idFinca;
    }

    public Long getIdPlanificacion() {
        return idPlanificacion;
    }

    public void setIdPlanificacion(Long idPlanificacion) {
        this.idPlanificacion = idPlanificacion;
    }

    public Long getIdCruce() {
        return idCruce;
    }

    public void setIdCruce(Long idCruce) {
        this.idCruce = idCruce;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }



    public Long getIdFinca() {
        return idFinca;
    }



    public void setIdFinca(Long idFinca) {
        this.idFinca = idFinca;
    }

    
}

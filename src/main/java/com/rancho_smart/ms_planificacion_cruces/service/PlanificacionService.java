package com.rancho_smart.ms_planificacion_cruces.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rancho_smart.ms_planificacion_cruces.entity.Planificacion;
import com.rancho_smart.ms_planificacion_cruces.repository.PlanificacionRepository;

@Service
public class PlanificacionService {

    @Autowired
    private PlanificacionRepository planificacionRepository;

    public List<Planificacion> getPlanificaciones() {
        return this.planificacionRepository.findAll();
    }

    public Optional<Planificacion> getPlanificacionById(Long id) {
        return this.planificacionRepository.findById(id);
    }

    public Planificacion savePlanificacion(Planificacion planificacion) {
        return this.planificacionRepository.save(planificacion);
    }

    public void deletePlanificacion(Long id) {
        this.planificacionRepository.deleteById(id);
    }
}
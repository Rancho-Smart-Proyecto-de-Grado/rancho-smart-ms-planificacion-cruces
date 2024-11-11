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
  
    public List<Planificacion> getPlanificacionesByIdCruce(Long idCruce){
        return this.planificacionRepository.findByIdCruce(idCruce);
    }

    public List<Planificacion> getPlanificacionesByIdFinca(Long idFinca){
        return this.planificacionRepository.findByIdFinca(idFinca);
    }

    public List<Planificacion> getPlanificacionesByIdUsuario(Long idUsuario){
        return this.planificacionRepository.findByIdUsuario(idUsuario);
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

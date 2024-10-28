package com.rancho_smart.ms_planificacion_cruces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_planificacion_cruces.entity.Planificacion;

@Repository
public interface PlanificacionRepository extends JpaRepository<Planificacion, Long>{
    
}

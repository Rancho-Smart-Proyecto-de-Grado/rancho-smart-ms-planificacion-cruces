package com.rancho_smart.ms_planificacion_cruces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_planificacion_cruces.entity.Planificacion;
import java.util.List;


@Repository
public interface PlanificacionRepository extends JpaRepository<Planificacion, Long>{
    public List<Planificacion> findByIdCruce(Long idCruce);
    public List<Planificacion> findByIdUsuario(Long idUsuario);
    public List<Planificacion> findByIdFinca(Long idFinca);
}

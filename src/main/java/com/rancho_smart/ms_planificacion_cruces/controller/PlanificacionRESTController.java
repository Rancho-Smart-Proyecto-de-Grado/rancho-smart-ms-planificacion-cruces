package com.rancho_smart.ms_planificacion_cruces.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rancho_smart.ms_planificacion_cruces.entity.Planificacion;
import com.rancho_smart.ms_planificacion_cruces.service.PlanificacionService;

@RestController
@RequestMapping(path = "/planificaciones")
public class PlanificacionRESTController {

    @Autowired
    private PlanificacionService planificacionService;

    @GetMapping
    public ResponseEntity<List<Planificacion>> getAllPlanificaciones() {
        List<Planificacion> listado = this.planificacionService.getPlanificaciones();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planificacion> getPlanificacionById(@PathVariable Long id) {
        Optional<Planificacion> planificacion = this.planificacionService.getPlanificacionById(id);
        return planificacion.map(ResponseEntity::ok)
                            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/cruce/{idCruce}")
    public ResponseEntity<List<Planificacion>> getPlanificacionesByIdCruce(@PathVariable Long idCruce){
        List<Planificacion> planificacionesCruce = this.planificacionService.getPlanificacionesByIdCruce(idCruce);
        if(planificacionesCruce.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(planificacionesCruce, HttpStatus.OK);
        }
    }

    @GetMapping("/finca/{idFinca}")
    public ResponseEntity<List<Planificacion>> getPlanificacionesByIdFinca(@PathVariable Long idFinca){
        List<Planificacion> planificacionesFinca = this.planificacionService.getPlanificacionesByIdFinca(idFinca);
        if(planificacionesFinca.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(planificacionesFinca, HttpStatus.OK);
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Planificacion>> getPlanificacionesByIdUsuario(@PathVariable Long idUsuario){
        List<Planificacion> planificacionesUsuario = this.planificacionService.getPlanificacionesByIdUsuario(idUsuario);
        if(planificacionesUsuario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(planificacionesUsuario, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Planificacion> savePlanificacion(@RequestBody Planificacion planificacion) {
        Planificacion planificacionCreada = this.planificacionService.savePlanificacion(planificacion);
        return new ResponseEntity<>(planificacionCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planificacion> updatePlanificacion(@PathVariable Long id, @RequestBody Planificacion planificacion) {
        if (!this.planificacionService.getPlanificacionById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            planificacion.setIdPlanificacion(id);
            Planificacion planificacionActualizada = this.planificacionService.savePlanificacion(planificacion);
            return new ResponseEntity<>(planificacionActualizada, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanificacion(@PathVariable Long id) {
        if (!this.planificacionService.getPlanificacionById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.planificacionService.deletePlanificacion(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

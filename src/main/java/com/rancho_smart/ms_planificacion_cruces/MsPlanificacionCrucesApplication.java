package com.rancho_smart.ms_planificacion_cruces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsPlanificacionCrucesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPlanificacionCrucesApplication.class, args);
	}

}

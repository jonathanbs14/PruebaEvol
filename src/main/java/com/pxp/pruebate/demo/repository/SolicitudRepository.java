package com.pxp.pruebate.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.pxp.pruebate.demo.entity.SolicitudEntity;

import reactor.core.publisher.Mono;

import java.util.List;



@Repository
public interface SolicitudRepository extends ReactiveCrudRepository<SolicitudEntity, Integer>{
	
	public Mono<SolicitudEntity> findByUsuario(String usuario);

}

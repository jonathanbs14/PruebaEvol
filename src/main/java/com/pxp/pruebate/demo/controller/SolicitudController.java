package com.pxp.pruebate.demo.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pxp.pruebate.demo.entity.SolicitudEntity;
import com.pxp.pruebate.demo.repository.SolicitudRepository;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/h2/operacion")
public class SolicitudController {


	 
	 @Autowired
	 private SolicitudRepository repository;
	 
	 @PostMapping
	 public Mono<SolicitudEntity> crearOperacionTipoCambio(@RequestBody String usuario ,@RequestBody float montoInicial,@RequestBody float  tipoCambio ){
		  long millis=System.currentTimeMillis();  	
		 SolicitudEntity entity = new SolicitudEntity();
			entity.setUsuario(usuario);
			entity.setMontoIncial(montoInicial);
			entity.setMontoFinal(montoInicial * tipoCambio);	 
			entity.setDia(new Date(millis));
	   return repository.save(entity);
	 }
	 
	 
	 @RequestMapping(value = "buscarOperaciones", method = RequestMethod.GET)
	 public    Mono<SolicitudEntity>  buscarOperacionTipoCambio(@RequestBody String usuario ){
		 return repository.findByUsuario(usuario);
	  }
	 
	 @RequestMapping(value = "actualizarOperacion", method = RequestMethod.PUT)
	 public Mono<SolicitudEntity>  actualizarOperacionTipoCambio(@RequestBody SolicitudEntity solicitud ){
		 return repository.save(solicitud);
	  }
}

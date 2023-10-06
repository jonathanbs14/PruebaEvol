package com.pxp.pruebate.demo.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class SolicitudEntity {
	
    @Id
    @GeneratedValue
    private int id;
    
    private String usuario;
    
    private float montoIncial;
    
    private float montoFinal;
    
    private float tipoCambio;
    
    private Date dia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public float getMontoIncial() {
		return montoIncial;
	}

	public void setMontoIncial(float montoIncial) {
		this.montoIncial = montoIncial;
	}

	public float getMontoFinal() {
		return montoFinal;
	}

	public void setMontoFinal(float montoFinal) {
		this.montoFinal = montoFinal;
	}

	public float getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(float tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}




    
    

}

package com.cibertec.bancocibertec.util;

import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@ResponseStatus
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String recurso;
	private String campo;
	private String valor;
	
	public ResourceNotFoundException(String recurso, 
			String campo, String valor) {
		super(String.format("%s no encuentrada con %s : '%s'", 
				recurso, campo, valor));
		this.recurso = recurso;
		this.campo = campo;
		this.valor = valor;
	}
}

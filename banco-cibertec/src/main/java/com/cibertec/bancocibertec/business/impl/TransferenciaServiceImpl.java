package com.cibertec.bancocibertec.business.impl;

import org.springframework.stereotype.Service;

import com.cibertec.bancocibertec.business.TransferenciaService;
import com.cibertec.bancocibertec.model.Transferencia;
import com.cibertec.bancocibertec.repository.TransferenciaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferenciaServiceImpl implements TransferenciaService {

	private TransferenciaRepository repository;
	
	@Override
	public void guardarTransfrencia(Transferencia transferencia) {
		repository.save(transferencia);
	}

}

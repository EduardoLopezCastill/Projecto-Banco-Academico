package com.cibertec.bancocibertec.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cibertec.bancocibertec.business.CuentaService;
import com.cibertec.bancocibertec.model.Cuenta;
import com.cibertec.bancocibertec.repository.CuentaRepository;
import com.cibertec.bancocibertec.util.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CuentaServiceImpl implements CuentaService {

	private CuentaRepository repository;
	
	@Override
	public Cuenta registrarCuenta(Cuenta cuenta) {
		return repository.save(cuenta);
	}

	@Override
	public Cuenta buscarCuentaPorNumero(String numero) {
		return repository.findByNumero(numero);
	}

	@Override
	public Cuenta actualizarCuenta(Cuenta cuenta, String id) {
		
		Cuenta objeto = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cuenta", "id", id));

		objeto.setId(id);
		objeto.setNumero(cuenta.getNumero());
		objeto.setSaldo(cuenta.getSaldo());
		return repository.save(objeto);
	}

	@Override
	public List<Cuenta> listarCuentas() {
		return repository.findAll();
	}

	@Override
	public Optional<Cuenta> listarCuentaPorId(String id) {
		repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cuenta", "id", id));
		return repository.findById(id);
	}

	@Override
	public void eliminarCuenta(String id) {
		repository.deleteById(id);
	}

}

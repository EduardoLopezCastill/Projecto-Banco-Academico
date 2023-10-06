package com.cibertec.bancocibertec.business;

import java.util.List;
import java.util.Optional;

import com.cibertec.bancocibertec.model.Cuenta;

public interface CuentaService {

	public Cuenta registrarCuenta(Cuenta cuenta);
	public Cuenta buscarCuentaPorNumero(String numero);
	public Cuenta actualizarCuenta(Cuenta cuenta, String id);
	public List<Cuenta> listarCuentas();
	public Optional<Cuenta> listarCuentaPorId(String id);
	public void eliminarCuenta(String id);
	
}

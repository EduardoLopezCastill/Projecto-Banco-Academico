package com.cibertec.bancocibertec.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.bancocibertec.business.CuentaService;
import com.cibertec.bancocibertec.business.TransferenciaService;
import com.cibertec.bancocibertec.model.Cuenta;
import com.cibertec.bancocibertec.model.Transferencia;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/banco")
@AllArgsConstructor
public class BancoController {

	private CuentaService cuentaService;
	private TransferenciaService transferenciaService;
	
	@PostMapping("/cuenta/registrar")
	public Cuenta registrarCuenta(@RequestBody Cuenta cuenta) {
		return cuentaService.registrarCuenta(cuenta);
	}
	
	@GetMapping("/cuenta/listar")
	public List<Cuenta> listarCuentas() {
		return cuentaService.listarCuentas();
	}
	
	@GetMapping("/cuenta/listar/{id}")
	public Optional<Cuenta> listarCuentaPorId(@PathVariable String id) {
		return cuentaService.listarCuentaPorId(id);
	}
	
	@PatchMapping("/cuenta/actualizar/{id}")
	public Cuenta actualizarCuenta(@RequestBody Cuenta cuenta, @PathVariable String id) {
		return cuentaService.actualizarCuenta(cuenta, id);
	}
	
	@DeleteMapping("/cuenta/eliminar/{id}")
	public void eliminarCuenta(@PathVariable String id) {
		cuentaService.eliminarCuenta(id);
	}
	
	@PostMapping("/transferencia")
	public ResponseEntity<?> registrarTransferencia(@RequestBody Transferencia transferencia) {
		
		//transferencia.setFecha(LocalDate.now().toString());
		transferenciaService.guardarTransfrencia(transferencia);
		
		Cuenta cuentaOrigen = cuentaService.buscarCuentaPorNumero(transferencia.getCuentaOrigen());
		cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - transferencia.getMonto());
		cuentaService.actualizarCuenta(cuentaOrigen, cuentaOrigen.getId());
		
		Cuenta cuentaDestino = cuentaService.buscarCuentaPorNumero(transferencia.getCuentaDestino());
		cuentaDestino.setSaldo(cuentaDestino.getSaldo() + transferencia.getMonto());
		cuentaService.actualizarCuenta(cuentaDestino, cuentaDestino.getId());
		
		return ResponseEntity.ok().build();
	}
}

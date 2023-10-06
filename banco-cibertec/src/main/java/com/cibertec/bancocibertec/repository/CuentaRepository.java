package com.cibertec.bancocibertec.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.bancocibertec.model.Cuenta;

@Repository
public interface CuentaRepository extends MongoRepository<Cuenta, String> {

	public Cuenta findByNumero(String numero);
}

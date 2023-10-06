package com.cibertec.bancocibertec.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.bancocibertec.model.Transferencia;

@Repository
public interface TransferenciaRepository extends MongoRepository<Transferencia, String> {

}

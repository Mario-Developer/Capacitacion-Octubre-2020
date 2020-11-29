package com.mx.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.Entity.Cliente;

public interface CRUDInterface extends CrudRepository <Cliente, Integer> {

}

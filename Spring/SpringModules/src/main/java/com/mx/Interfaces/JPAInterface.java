package com.mx.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Entity.Cliente;

@Repository
public interface JPAInterface extends JpaRepository <Cliente, Integer>{

}

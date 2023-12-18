package com.paradise.modulo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paradise.modulo5.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>
{
	 
	 
}
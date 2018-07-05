package com.mango.clientesrestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mango.clientesrestful.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

}

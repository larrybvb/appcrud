package com.armadillo.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.armadillo.crud.model.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

	@Query(value = "select * from fn_listarclientes()", nativeQuery = true)	
	List<Cliente> listaClientes();
	
	@Query(value = "select * from fn_listarclientes_pg(:Paging_PageSize, :Paging_PageNumber)", nativeQuery = true)	
	List<Cliente> listaClientesPg(@Param("Paging_PageSize") int  Paging_PageSize, @Param("Paging_PageNumber") int Paging_PageNumber);
}



package com.armadillo.crud.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.armadillo.crud.model.Cliente;
import com.armadillo.crud.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente guardar (Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listar(){
		return clienteRepository.listaClientes();
	}
	
	public List<Cliente> listarPaginado(int Paging_PageSize, int Paging_PageNumber){
		return clienteRepository.listaClientesPg(Paging_PageSize, Paging_PageNumber);
	}
	
	public Page<Cliente> listarPaginado2(Pageable pageable){
		return clienteRepository.findAll(pageable);
	}
	

}

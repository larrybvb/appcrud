package com.armadillo.crud.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.armadillo.crud.model.Cliente;
import com.armadillo.crud.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRest {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping
	private ResponseEntity<Cliente> guardar (@RequestBody Cliente cliente){
		Cliente clienteTemp = clienteService.guardar(cliente);
		try {
			return ResponseEntity.created(new URI("/api/cliente"+clienteTemp.getId())).body(clienteTemp);
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping("/lista")
	private ResponseEntity<List<Cliente>> listar(){
		List<Cliente> listcliente = clienteService.listar();
		return new ResponseEntity<List<Cliente>>(listcliente,HttpStatus.OK);
	}
	
	
	@GetMapping("/listar")
	private ResponseEntity<List<Cliente>> listarpaginado(@PageableDefault(size = 10, page = 0)Pageable pageable){
		List<Cliente> listcliente = clienteService.listarPaginado(pageable.getPageSize(), pageable.getPageNumber());
		return new ResponseEntity<List<Cliente>>(listcliente,HttpStatus.OK);
		
	}
	
	@GetMapping("/listar2")
	private Page<Cliente> listarpageable(@PageableDefault(size = 10, page = 0)Pageable pageable){
		Page<Cliente> listcliente = clienteService.listarPaginado2(pageable);
		
			return listcliente;
		
	}

}

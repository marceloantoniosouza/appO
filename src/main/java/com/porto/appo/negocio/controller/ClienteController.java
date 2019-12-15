package com.porto.appo.negocio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porto.appo.negocio.dto.ClienteDTO;
import com.porto.appo.negocio.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/{codigo}")
	public ClienteDTO cliente(@PathVariable ("codigo") Integer codigo) {
		return clienteService.clientes().get(0);
	}
	
	@GetMapping("")
	public List<ClienteDTO> clientes() {
		return clienteService.clientes();
	}
	
	@GetMapping("/appI")
	public List<ClienteDTO> clientesAppI() {
		return clienteService.clientesAppI();
	}


}

package com.porto.appo.negocio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porto.appo.negocio.dto.ClienteDTO;

@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {
	
	@GetMapping("/{codigo}")
	public ClienteDTO empresa(@PathVariable ("codigo") Integer codigo) {
		return new ClienteDTO(1, "Empresa");
	}

}

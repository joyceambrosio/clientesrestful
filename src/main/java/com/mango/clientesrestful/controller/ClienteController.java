package com.mango.clientesrestful.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mango.clientesrestful.controller.validator.ClienteValidator;
import com.mango.clientesrestful.model.Cliente;
import com.mango.clientesrestful.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;
	@Autowired
	private ClienteValidator validator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}

	@GetMapping(produces = "application/json")
	public @ResponseBody Map<String, Iterable<Cliente>> getClientes() {
		Iterable<Cliente> listaClientes = repository.findAll();
		Map<String, Iterable<Cliente>> clientesMap = new HashMap<String, Iterable<Cliente>>();
		clientesMap.put("clientes", listaClientes);

		return clientesMap;
	}

	@PostMapping()
	public Cliente cria(@RequestBody @Valid Cliente cliente) throws Exception {
		return repository.save(cliente);
	}

	@PostMapping("/process")
	public Cliente process(@RequestBody @Valid Cliente cliente) throws Exception {
		return cliente;
	}

	@DeleteMapping
	public Cliente delete(@RequestBody Cliente cliente) {
		repository.delete(cliente);
		return cliente;
	}

	@PutMapping
	public Cliente update(@RequestBody Cliente cliente) throws Exception {
		return repository.save(cliente);
	}

}

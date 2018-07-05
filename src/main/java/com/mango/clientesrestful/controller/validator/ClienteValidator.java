package com.mango.clientesrestful.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mango.clientesrestful.model.Cliente;
import com.mango.negociorest.business.exceptions.IdadeExcepction;
import com.mango.negociorest.business.exceptions.NomeException;
import com.mango.negociorest.business.exceptions.RendaException;
import com.mango.negociorest.business.model.ClienteBusiness;
import com.mango.negociorest.clienteInterface.ICliente;

@Component
public class ClienteValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Cliente.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "O nome não pode ser vazio");
		ValidationUtils.rejectIfEmpty(errors, "idade", "A idade não pode ser vazia");
		ValidationUtils.rejectIfEmpty(errors, "renda", "A renda não pode ser vazia");

		Cliente cliente = (Cliente) target;

		if (!cliente.getNome().contains(" ")) {
			errors.rejectValue("nome", "Informe um nome e sobrenome!");
		}

		if (cliente.getIdade() <= 0) {
			errors.rejectValue("idade", "Informe um nome e sobrenome!");
		}

		if (cliente.getRenda() <= 0) {
			errors.rejectValue("renda", "A renda deve ser informada, com um número maior que zero!");
		}

		ICliente process;
		try {
			process = new ClienteBusiness(cliente.getNome(), cliente.getIdade(), cliente.getRenda());
			cliente.setRenda(process.getRenda());
			cliente.setLimiteDeCredito(process.getLimiteDeCredito());
			cliente.setClassificacao(process.getClassificacao());

		} catch (NomeException e) {
			errors.rejectValue("nome", "Informe um nome e sobrenome!");
		} catch (IdadeExcepction e) {
			errors.rejectValue("idade", "Informe um nome e sobrenome!");
		} catch (RendaException e) {
			errors.rejectValue("renda", "A renda deve ser informada, com um número maior que zero!");
		} catch (Exception e) {
			
		}

	}

}

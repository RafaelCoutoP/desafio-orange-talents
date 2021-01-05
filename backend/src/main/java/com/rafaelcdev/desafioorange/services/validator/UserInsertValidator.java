package com.rafaelcdev.desafioorange.services.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.rafaelcdev.desafioorange.dto.UserDTO;
import com.rafaelcdev.desafioorange.entities.User;
import com.rafaelcdev.desafioorange.repositories.UserRepository;
import com.rafaelcdev.desafioorange.resources.exceptions.FieldMessage;
import com.rafaelcdev.desafioorange.services.validator.utils.BR;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserDTO> {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(UserInsertValid ann) {
	}

	@Override
	public boolean isValid(UserDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if (!BR.isValidCPF(dto.getCpf())) {
			list.add(new FieldMessage("cpf", "Insira o CPF sem caracteres especiais ou o CPF está inválido "));
		}
		
		User userCpf = userRepository.findByCpf(dto.getCpf());
		if(userCpf != null) {
			list.add(new FieldMessage("cpf", "CPF já existente"));
		}
		
		User user = userRepository.findByEmail(dto.getEmail());
		if(user != null) {
			list.add(new FieldMessage("email", "Email já existe, favor tentar outro email"));
		}
		
		
		// Está inserindo na lista de erros do beans validation do tipo dele.
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty(); 
	}
}
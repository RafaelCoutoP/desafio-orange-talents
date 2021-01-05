package com.rafaelcdev.desafioorange.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelcdev.desafioorange.dto.UserDTO;
import com.rafaelcdev.desafioorange.entities.User;
import com.rafaelcdev.desafioorange.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getDataDeNascimento());
		entity = repository.save(entity);
		return new UserDTO(entity);
	}
}

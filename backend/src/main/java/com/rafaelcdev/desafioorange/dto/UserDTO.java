package com.rafaelcdev.desafioorange.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.rafaelcdev.desafioorange.entities.User;
import com.rafaelcdev.desafioorange.services.validator.UserInsertValid;

@UserInsertValid
public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Size(min = 5, max = 60, message = "min 5 - max 60")
	@NotBlank(message = "Campo requerido")
	private String nome;
	
	@NotBlank(message = "Campo requerido")
	@Email(message = "Favor entrar com email válido")
	private String email;
	
	@NotBlank(message = "Campo requerido")
	private String cpf;
	
	@PastOrPresent(message = "Data do produto não pode ser futura")
	private Instant dataDeNascimento;
	
	public UserDTO() {
	}

	public UserDTO(Long id, String nome, String email, String cpf, Instant dataDeNascimento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		cpf = entity.getCpf();
		dataDeNascimento = entity.getDataDeNascimento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Instant getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Instant dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}

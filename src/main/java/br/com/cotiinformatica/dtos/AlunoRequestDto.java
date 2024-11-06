package br.com.cotiinformatica.dtos;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlunoRequestDto {
	
	@Size(min = 8, max = 100, message = "Por favor, informe o nome de 8 a 100 caracteres.")
	@NotEmpty(message = "Por favor, informe o nome do usuário.")
	private String nome;
	
	@Size(min = 11, max = 11, message = "Por favor, informe um CPF Válido.")
	@NotEmpty(message = "Por favor, informe o CPF.")
	private String cpf;
	
	@Email(message = "Por favor, informe o endereço de email válido.")
	@NotEmpty(message = "Por favor, informe o email do usúario")
	private String email;
	
	@Size(min = 11, max = 16, message = "Por favor, informe um telefone Válido.")
	@NotEmpty(message = "Por favor, informe o telefone.")
	private String telefone;
	
	private List<String> turmas;
	
}

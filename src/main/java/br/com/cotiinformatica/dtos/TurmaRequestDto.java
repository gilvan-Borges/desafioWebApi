package br.com.cotiinformatica.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TurmaRequestDto {
	
	@Size(min = 4, max = 4, message = "Por favor, informe o ano letivo corretamente EX:'2024'.")
	@NotEmpty(message = "Por favor, informe o ano letivo.")
	private String anoLetivo;
	
	@Size(min = 2, max = 10, message = "Por favor, informe o numero da turma correto EX:'01'.")
	@NotEmpty(message = "Por favor, informe o numero da turma.")
	private String numero;
	
	@Size(min = 3, max = 100, message = "Por favor, informe a Descrição corretamente EX:'ESPANHOL'.")
	@NotEmpty(message = "Por favor, informe a Descrição.")
	private String descricao;
	
	@Size(min = 3, max = 100, message = "Por favor, informe o nivel do curso 'BASICO, INTERMEDIARIO, AVANCADO' corretamente'")
	@NotEmpty(message = "Por favor, informe o nivel.")
	private String nivel;

}

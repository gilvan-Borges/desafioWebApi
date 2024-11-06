package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.AlunoRequestDto;
import br.com.cotiinformatica.entities.Aluno;
import br.com.cotiinformatica.services.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alunos")
public class AlunosController {
	
	@Autowired
	private AlunoService alunoService;

	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody @Valid AlunoRequestDto dto) {
			
		return alunoService.cadastrarAluno(dto);
	}
	
	@GetMapping("/consultar")
	public List<Aluno> consultar() {
		return alunoService.consultarAluno();
	}
	
	@GetMapping("/consultar/{id}")
	public Aluno consultar(@PathVariable @Valid UUID id) {
		return alunoService.consultarAlunoPorId(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public String atualizar(@PathVariable @Valid UUID id, @RequestBody AlunoRequestDto dto) {
		
		return alunoService.atualizarAluno(id ,dto);
		
	}
	
	
	@DeleteMapping("/excluir/{id}")
	public String excluir(@PathVariable @Valid UUID id) {
		return alunoService.excluirAluno(id);
	}
	
}

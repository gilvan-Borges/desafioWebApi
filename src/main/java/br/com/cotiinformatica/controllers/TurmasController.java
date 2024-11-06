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

import br.com.cotiinformatica.dtos.TurmaRequestDto;
import br.com.cotiinformatica.entities.Turma;
import br.com.cotiinformatica.services.TurmaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/turmas")
public class TurmasController {
	
	@Autowired
	private TurmaService turmaService;
	
	
	@PostMapping()
	public String cadastrarTurma(@RequestBody @Valid TurmaRequestDto dto) {
		
		return turmaService.cadastrarTurma(dto);
	}
	
	@PutMapping("{id}")
	public String atualizarTurma(@PathVariable @Valid UUID id, @RequestBody TurmaRequestDto dto) {
		
		return turmaService.atualizarTurma(dto);
	}
	
	@GetMapping
	public List<Turma> consultarTurmas() {
	    return turmaService.consultarTurmas();
	}

	@GetMapping("{id}")
	public Turma consultarTurmaPorId(@PathVariable @Valid UUID id) {
	    return turmaService.consultarTurmaPorId(id);
	}
	
	@DeleteMapping("{id}")
	public String excluirTurma(@PathVariable @Valid UUID id) {
		return turmaService.excluirTurma(id);
	}
}

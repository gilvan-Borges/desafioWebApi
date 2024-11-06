package br.com.cotiinformatica.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.TurmaRequestDto;
import br.com.cotiinformatica.entities.Turma;
import br.com.cotiinformatica.repositories.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	public String cadastrarTurma(TurmaRequestDto dto) {

		var turma = new Turma();

		turma.setId(UUID.randomUUID());
		turma.setAnoLetivo(dto.getAnoLetivo());
		turma.setNumero(dto.getNumero());
		turma.setDescricao(dto.getDescricao());
		turma.setNivel(dto.getNivel());

		turmaRepository.save(turma);

		return "Turma cadastrada com sucesso.";
	}

	@SuppressWarnings("unused")
	public String atualizarTurma(TurmaRequestDto dto) {
		var turma = new Turma();

		if (turma != null) {

			turma.setAnoLetivo(dto.getAnoLetivo());
			turma.setNumero(dto.getNumero());
			turma.setDescricao(dto.getDescricao());

			if (!turmaRepository.existsByIdAndNumero(turma.getId(), turma.getNumero())) {

				turmaRepository.save(turma);
				return "Turma atualizada com sucesso.";
			} else {
				return "Não é possível atualizar os dados pois o número da turma '" + turma.getNumero()
						+ "' já pertence a outra Turma.";
			}

		} else {
			return "Turma não encontrada.";
		}
	}

	public String excluirTurma(UUID id) {

		if (turmaRepository.existsById(id)) {
			turmaRepository.deleteById(id);
			return "Turma excluída com sucesso.";
		} else {
			return "Turma não encontrada.";
		}
	}

	public List<Turma> consultarTurmas() {

		return turmaRepository.findAll();
	}

	public Turma consultarTurmaPorId(UUID id) {

		if (turmaRepository.existsById(id)) {
			return turmaRepository.findById(id).get();
		} else {
			throw new RuntimeException("Turma não encontrada.");
		}
	}
}
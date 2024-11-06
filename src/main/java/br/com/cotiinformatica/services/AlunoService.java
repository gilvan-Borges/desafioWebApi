
package br.com.cotiinformatica.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.AlunoRequestDto;
import br.com.cotiinformatica.entities.Aluno;
import br.com.cotiinformatica.entities.Turma;
import br.com.cotiinformatica.repositories.AlunoRepository;
import br.com.cotiinformatica.repositories.TurmaRepository;
import jakarta.transaction.Transactional;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private TurmaRepository turmaRepository;

	@Transactional
	public String cadastrarAluno(AlunoRequestDto dto) {

		Aluno aluno = alunoRepository.findByCpfEmail(dto.getCpf(), dto.getEmail()).orElseGet(() -> {

			Aluno novoAluno = new Aluno();
			novoAluno.setId(UUID.randomUUID());
			novoAluno.setNome(dto.getNome());
			novoAluno.setCpf(dto.getCpf());
			novoAluno.setEmail(dto.getEmail());
			novoAluno.setTelefone(dto.getTelefone());
			return novoAluno;
		});

		validarNovoAluno(aluno);

		Turma turma = buscarTurmaPorId(turmaRepository.findAll().get(0).getId());

		validarMatriculaAluno(aluno, turma);

		adicionarAlunoNaTurma(aluno, turma);

		alunoRepository.save(aluno);
		return "Aluno matriculado com sucesso.";
	}
	@Transactional
	public String atualizarAluno(UUID id, AlunoRequestDto dto) {

		Aluno aluno = alunoRepository.findByCpfEmail(dto.getCpf(), dto.getEmail()).orElseGet(() -> {
			
			Aluno alunoAtualizado = new Aluno();
			alunoAtualizado.setId(UUID.randomUUID());
			alunoAtualizado.setNome(dto.getNome());
			alunoAtualizado.setCpf(dto.getCpf());
			alunoAtualizado.setEmail(dto.getEmail());
			alunoAtualizado.setTelefone(dto.getTelefone());
			return alunoAtualizado;
		});

		List<Turma> novasTurmas = new ArrayList<>();
		for (String turmaId : dto.getTurmas()) {
			Turma turma = buscarTurmaPorId(UUID.fromString(turmaId));
			validarMatriculaAluno(aluno, turma);
			novasTurmas.add(turma);
		}
		
		if (aluno.getTurmas() == null) {
			aluno.setTurmas(new ArrayList<>());
		}

		for (Turma turma : aluno.getTurmas()) {
			turma.getAlunos().remove(aluno);
		}

		aluno.setTurmas(novasTurmas);
		for (Turma turma : novasTurmas) {
			turma.getAlunos().add(aluno);
		}

		validarNovoAluno(aluno);

		alunoRepository.save(aluno);
		return "Aluno atualizado com sucesso.";
	}

	public String excluirAluno(UUID id) {
		if (!alunoRepository.existsById(id))
			return "Aluno não encontrado.";

		if (alunoRepository.alunoMatriculadoEmTurma(id))
			return "Não é possível excluir o aluno pois ele está matriculado em uma turma";

		alunoRepository.deleteById(id);
		return "Aluno excluído com sucesso.";
	}

	public List<Aluno> consultarAluno() {
		return alunoRepository.findAll();
	}

	public Aluno consultarAlunoPorId(UUID id) {

		if (alunoRepository.existsById(id)) {
			var aluno = new Aluno();

			aluno.setNome(alunoRepository.findById(id).get().getNome());
			aluno.setCpf(alunoRepository.findById(id).get().getCpf());
			aluno.setEmail(alunoRepository.findById(id).get().getEmail());
			aluno.setTelefone(alunoRepository.findById(id).get().getTelefone());

			return alunoRepository.findById(id).get();
		}
		throw new IllegalArgumentException("Aluno não encontrado");
	}

	private void validarNovoAluno(Aluno aluno) {
		validarCpf(aluno.getCpf());
		validarEmail(aluno.getEmail());
	}

	private void validarCpf(String cpf) {
		if (cpf == null || !cpf.matches("\\d{11}")) {
			throw new IllegalArgumentException("CPF inválido");
		}
	}

	private void validarEmail(String email) {

		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("Email inválido: o email não pode ser nulo ou vazio.");
		}

		String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

		if (!email.matches(emailRegex)) {
			throw new IllegalArgumentException("Email inválido: formato incorreto.");
		}
	}

	private Turma buscarTurmaPorId(UUID turmaId) {

		if (turmaRepository.existsById(turmaId)) {
			return turmaRepository.findById(turmaId).get();
		} else {
			throw new IllegalArgumentException("Turma não encontrada");
		}
	}

	private void validarMatriculaAluno(Aluno aluno, Turma turma) {
		if (turma.getAlunos().contains(aluno)) {
			throw new IllegalArgumentException("Aluno já matriculado nesta turma");
		}
		if (turma.getAlunos().size() >= 5) {
			throw new IllegalArgumentException("Turma já possui o limite de 5 alunos");
		}
	}

	private void adicionarAlunoNaTurma(Aluno aluno, Turma turma) {
		if (aluno.getTurmas() == null) {
			aluno.setTurmas(new ArrayList<>());
		}
		aluno.getTurmas().add(turma);
		turma.getAlunos().add(aluno);
	}

}

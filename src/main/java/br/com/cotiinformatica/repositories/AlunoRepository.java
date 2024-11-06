package br.com.cotiinformatica.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, UUID>{
	
	
	@Query("FROM Aluno a WHERE a.email = :email AND a.cpf = :cpf")
	boolean existsByEmailCpf(@Param("email") String email, @Param("cpf") String cpf);
	
	@Query("SELECT COUNT(a) > 0 FROM Aluno a JOIN a.turmas t WHERE a.id = :id")
	boolean alunoMatriculadoEmTurma(@Param("id") UUID id);
	
	@Query("FROM Aluno a WHERE a.cpf = :cpf OR a.email = :email")
	Optional<Aluno> findByCpfEmail(String cpf, String email);
	
	
}

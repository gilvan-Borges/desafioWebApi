package br.com.cotiinformatica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cotiinformatica.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, UUID>{

	@Query("FROM Turma t WHERE t.id = :id AND t.numero = :numero")
	 boolean existsByIdAndNumero(@Param("id") UUID id, @Param("numero") String numero);
	 
}

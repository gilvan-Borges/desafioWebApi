package br.com.cotiinformatica.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_turma")
public class Turma {
	
	@Id
	@Column(name = "id")
	private UUID  id;
	
	@Column(name = "ano_letivo", length = 150, nullable = false)
	private String anoLetivo;
	
	@Column(name = "numero", length = 10, nullable = false)
	private String numero;
	
	@Column(name = "descricao", length = 500, nullable = false)
	private String descricao;
	
	@Column(name = "nivel", length = 30,  nullable = false)
	private String nivel;
	
	
	@ManyToMany(mappedBy = "turmas")
	@JsonBackReference
	private List<Aluno> alunos = new ArrayList<>();
}

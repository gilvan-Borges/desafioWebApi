package br.com.cotiinformatica.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.cotiinformatica.repositories.AlunoRepository;
import br.com.cotiinformatica.repositories.TurmaRepository;

@Component
public class LoadDataComponent implements ApplicationRunner {

	@Autowired
	TurmaRepository turmaRepository;

	@Autowired
	AlunoRepository alunoRepository;


	@Override
	public void run(ApplicationArguments args) throws Exception {

		//TODO
	}

}

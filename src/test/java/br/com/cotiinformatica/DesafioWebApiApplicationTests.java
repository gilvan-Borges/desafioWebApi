package br.com.cotiinformatica;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import br.com.cotiinformatica.dtos.AlunoRequestDto;

@SpringBootTest
@AutoConfigureMockMvc
class DesafioWebApiApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void cadastrarAlunoTest() throws Exception {
		
		var dto = new AlunoRequestDto();
		var faker = new Faker();

		dto.setNome(faker.name().fullName());
		dto.setEmail(faker.internet().emailAddress());
		dto.setCpf(faker.number().digits(11));
		dto.setTelefone(faker.phoneNumber().cellPhone());
		dto.setTurmas(Collections.singletonList("bf5f6149-30be-4569-aa85-6ffe2b5b8c36"));

		var result = mockMvc.perform(post("/api/alunos/cadastrar").contentType("application/json")
				.content(objectMapper.writeValueAsString(dto))).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		assert (content.contains("Aluno cadastrado com sucesso."));
	}

}

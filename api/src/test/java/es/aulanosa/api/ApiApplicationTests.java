package es.aulanosa.api;

import es.aulanosa.api.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Test
	void contextLoads() {
		System.out.println(usuarioRepository.findAll());;
	}

}

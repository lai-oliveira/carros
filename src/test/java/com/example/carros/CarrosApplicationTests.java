package com.example.carros;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarrosService;
import com.example.carros.domain.dto.CarroDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarrosApplicationTests {

	@Autowired
	private CarrosService service;

	@Test
	public void test1(){
		Carro carro = new Carro();
		carro.setNome("Siena");
		carro.setTipo("Basico");

		CarroDTO c = service.insert(carro);
		assertNotNull(c);

		Long id = c.getId();
		assertNotNull(id);

		//Buscando um objeto.
		Optional<CarroDTO> op = service.getCarroById(id);
		assertTrue(op.isPresent());
		c = op.get();
		assertEquals("Siena",c.getNome());
		assertEquals("Basico", c.getTipo());

		service.delete(id);

		//Verificar se deletou.
		assertFalse(service.getCarroById(id).isPresent());
	}

	@Test
	public void testLista() {
		List<CarroDTO> carros = service.getCarros();
	}

}

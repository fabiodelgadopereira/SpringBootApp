package com.cliente.springboot;

import com.cliente.springboot.model.Contato;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SpringbootApplicationTests {

	@Test
	void contextLoads() {
		Contato con = new Contato("zaphod", "zaphod@mail.com","mensagem");
		assertEquals(con.getNome(),"zaphod");
	}

}

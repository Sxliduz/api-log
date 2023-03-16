package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Client;

@RestController
public class ClientController {

	@GetMapping("/clients")
	public List<Client> list() {
		Client client = new Client();
		client.setId(1L);
		client.setName("Gui");
		client.setPhone("9129129");
		client.setEmail("teste@gmail.com");
		
		Client client2 = new Client();
		client2.setId(2L);
		client2.setName("Oitudobom");
		client2.setPhone("3211212121");
		client2.setEmail("oiaham@gmail.com");
		
		return Arrays.asList(client, client2);
	}
}

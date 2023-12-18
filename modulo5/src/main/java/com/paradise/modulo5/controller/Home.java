package com.paradise.modulo5.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Home {

	@GetMapping(value = { "/", "/index.html" })
	public String home() {
		return "index.html";
	}

	@GetMapping("/promocao")
	public String promocao() {
		return "promocao";
	}

	@GetMapping("/destino")
	public String destino() {
		return "Destino/destino";
	}

	@GetMapping("/contato")
	public String contato() {
		return "/contato";

	}
	
	@GetMapping("/cadastro")
	public String cadastro() {
		return "/cadastro";
	}

}
	

package com.paradise.modulo5.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.paradise.modulo5.entities.Cliente;
import com.paradise.modulo5.repositories.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // lista todos os dados do banco usuario
    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("cliente/list");

        List<Cliente> clientes = clienteRepository.findAll();
        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }

    @GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("cliente/cadastro");

		modelAndView.addObject("cliente", new Cliente());

		return modelAndView;
	}

    @PostMapping("/cadastrar")
	public ModelAndView cadastrar(Cliente cliente) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

		clienteRepository.save(cliente);

		return modelAndView;
	}
    
    @GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cliente/edit"); //nome da pasta / arquivo html
 
		Cliente cliente = clienteRepository.getReferenceById(id);
		modelAndView.addObject("cliente", cliente);
 
		return modelAndView;
	}
	
	@PostMapping("/{id}/editar")
	public ModelAndView editar(Cliente cliente) {	
		
		
		clienteRepository.save(cliente);
		ModelAndView modelAndView = new ModelAndView("redirect:/cliente");
 
		return modelAndView;
	}
	
	 @GetMapping("/{id}/excluir")
		public ModelAndView excluir(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("redirect:/cliente"); //nome da pasta / arquivo html
	 
			 clienteRepository.deleteById(id);
				 
			return modelAndView;
		}
	
}
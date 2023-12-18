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

import com.paradise.modulo5.entities.Destino;
import com.paradise.modulo5.repositories.DestinoRepository;

@Controller
@RequestMapping("/destino")
public class DestinoController {

    @Autowired
    private DestinoRepository destinoRepository;

    // lista todos os dados do banco usuario
    @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("destino/list");

        List<Destino> destino = destinoRepository.findAll();
        modelAndView.addObject("destino", destino);

        return modelAndView;
    }

    @GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("destino/form");

		modelAndView.addObject("destino", new Destino());

		return modelAndView;
	}

    @PostMapping("/cadastrar")
	public ModelAndView cadastrar(Destino destino) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/destino");

		destinoRepository.save(destino);

		return modelAndView;
	}
    
    @GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("destino/edit"); //nome da pasta / arquivo html
 
		Destino destino = destinoRepository.getReferenceById(id);
		modelAndView.addObject("destino", destino);
 
		return modelAndView;
	}
	
	@PostMapping("/{id}/editar")
	public ModelAndView editar(Destino destino) {	
		
		
		destinoRepository.save(destino);
		ModelAndView modelAndView = new ModelAndView("redirect:/destino");
 
		return modelAndView;
	}
	
	 @GetMapping("/{id}/excluir")
		public ModelAndView excluir(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("redirect:/destino"); //nome da pasta / arquivo html
	 
			 destinoRepository.deleteById(id);
				 
			return modelAndView;
		}
	
}
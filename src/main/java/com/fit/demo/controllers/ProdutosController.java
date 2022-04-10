package com.fit.demo.controllers;





import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.fit.demo.model.produto;
import com.fit.demo.repository.ProdutosRepository;




@Controller
public class ProdutosController{

	
	@Autowired
	private ProdutosRepository fr;
	
	
	@RequestMapping("/cadastrar")
	public String form() {
		return "produto/form";
	}

	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String form(@Valid produto produto , BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem",  "Verifique os campos");
			return "redirect:/cadastrar";
		}
		
		fr.save(produto);
		attributes.addFlashAttribute("mensagem", "Produto adicionada com sucesso!");
		return "redirect:/cadastrar";
		
	}
	
	
}

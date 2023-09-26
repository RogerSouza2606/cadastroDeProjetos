package br.com.rogerio.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.rogerio.model.Projeto;

@Controller
@ResponseBody
public class ProjetoController {
	
	/*@GetMapping("/olamundo")
	public String olaMundo() {
		return "Olá Mundo";
	}*/
	
	@GetMapping("/listarProjetos")
	public List<Projeto> listarProjetos() {
		Projeto p1 = new Projeto(35, 1299.99, "Celular Sansung");
		Projeto p2 = new Projeto(10, 199.99, "Cafeteria arno");
		Projeto p3 = new Projeto(150, 9.99, "Rato sem fio");
		
		return Arrays.asList(p1, p2, p3);
	}
}

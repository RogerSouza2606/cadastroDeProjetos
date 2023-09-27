package br.com.rogerio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogerio.model.Projeto;
import br.com.rogerio.repository.ProjetoRepository;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
	

		/*@GetMapping("/olamundo")
		public String olaMundo() {
			return "Olá Mundo";
		}*/
		
		@Autowired
		private ProjetoRepository projetoRepository;
		
		@GetMapping
		public List<Projeto> listarProdutos() {
			/*Produto p1 = new Produto("Celular sansuga", 35, 1299.99);
			Produto p2 = new Produto("Cafeteira arno", 10, 199.99);
			Produto p3 = new Produto("Rato sem fio", 150, 9.95);
			
			return Arrays.asList(p1, p2, p3);*/
			List<Projeto> produtos = projetoRepository.findAll();
			return produtos;
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Projeto> findById(@PathVariable Long id) {
			return projetoRepository.findById(id)
					.map(objetoGravado -> ResponseEntity.ok().body(objetoGravado))
					.orElse(ResponseEntity.notFound().build());
		}		
		

	@PostMapping
	public ResponseEntity<Projeto> cadastroProjeto(@RequestBody Projeto projeto){
		return ResponseEntity.status(HttpStatus.CREATED).body(projeto);
}		
	@PutMapping("/{id}")
	public ResponseEntity<Projeto> atualizarProjetos(@PathVariable Long id, @RequestBody Projeto projeto) {
		return projetoRepository.findById(id)
				.map(objetoGravado -> {
					objetoGravado.setNome(projeto.getNome());
					objetoGravado.setQuantidade(projeto.getQuantidade());
					objetoGravado.setPreco(projeto.getPreco());
					Projeto projetoAtualizado = projetoRepository.save(objetoGravado);
					return ResponseEntity.ok().body(projetoAtualizado);   
				})
				.orElse(ResponseEntity.notFound().build());
		
	}
}
	

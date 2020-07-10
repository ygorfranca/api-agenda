package br.com.athome.apiagenda.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.athome.apiagenda.model.Pessoa;
import br.com.athome.apiagenda.service.PessoaService;

@RequestMapping("/api/v1/pessoa")
@RestController
public class PessoaController {

	private final PessoaService pessoaService;

	@Autowired
	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	//post request
	@PostMapping
	public void addPessoa(@RequestBody Pessoa pessoa) {
		pessoaService.addPessoa(pessoa);
	}
	
	//get request
	@GetMapping
	public List<Pessoa> getAllPessoa(){
		return pessoaService.getAllPessoa();
	}
	
	//get request com passagem de parametro atraves do request
	// localhost:8080/api/v1/pessoa/a816665c-c1ee-11ea-b3de-0242ac130004
	@GetMapping(path = "{id}")
	public Pessoa getPessoaById(@PathVariable("id") UUID id) {
		return pessoaService.getPessoaById(id).orElse(null);
	}
	
	@DeleteMapping(path = "{id}")
	public void deletePessoa(@PathVariable("id") UUID id) {
		pessoaService.deletePessoa(id);
	}
	
	@PutMapping(path = "{id}")
	public void updatePessoa(@PathVariable UUID id, @RequestBody Pessoa pessoaToUpdate) {
		pessoaService.updatePessoa(id, pessoaToUpdate);
	}
	
}

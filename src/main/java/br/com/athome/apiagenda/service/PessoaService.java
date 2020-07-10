package br.com.athome.apiagenda.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.athome.apiagenda.dao.PessoaDao;
import br.com.athome.apiagenda.model.Pessoa;

@Service
public class PessoaService {

	private final PessoaDao pessoaDao;
	
	@Autowired
	public PessoaService(@Qualifier("pessoaDataAcess")PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public int addPessoa(Pessoa pessoa) {
		return pessoaDao.insertPessoa(pessoa);
	}
	
	public List<Pessoa> getAllPessoa(){
		return pessoaDao.selectAllPessoas();
	}
	
	public Optional<Pessoa> getPessoaById(UUID id){
		return pessoaDao.selectPessoaById(id);
	}
	
	public int deletePessoa(UUID id) {
		return pessoaDao.deletePessoaById(id);
	}
	
	public int updatePessoa(UUID id, Pessoa newPessoa) {
		return pessoaDao.updatePessoaById(id, newPessoa);
	}
	
}

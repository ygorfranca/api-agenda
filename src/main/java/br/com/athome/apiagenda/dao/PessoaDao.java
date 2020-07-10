package br.com.athome.apiagenda.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.athome.apiagenda.model.Pessoa;

public interface PessoaDao {

	int insertPessoa(UUID id, Pessoa pessoa);
	
	default int insertPessoa(Pessoa pessoa) {
		UUID id = UUID.randomUUID();
		return insertPessoa(id, pessoa);
	}
	
	List<Pessoa> selectAllPessoas();
	
	Optional<Pessoa> selectPessoaById(UUID id);
	
	int deletePessoaById(UUID id);
	
	int updatePessoaById(UUID id, Pessoa pessoa);
}

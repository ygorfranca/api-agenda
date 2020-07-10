package br.com.athome.apiagenda.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.athome.apiagenda.model.Pessoa;

@Repository("pessoaDataAcess")
public class PersonDataAcessService implements PessoaDao {

	private static List<Pessoa> DB = new ArrayList<>();

	@Override
	public int insertPessoa(UUID id, Pessoa pessoa) {
		DB.add(new Pessoa(id, pessoa.getNome(), pessoa.getTelefone()));
		return 1;
	}

	@Override
	public List<Pessoa> selectAllPessoas() {
		return DB;
	}

	@Override
	public Optional<Pessoa> selectPessoaById(UUID id) {
		return DB.stream().filter(pessoa -> pessoa.getId().equals(id)).findFirst();
	}

	@Override
	public int deletePessoaById(UUID id) {
		Optional<Pessoa> pessoaMaybe = selectPessoaById(id);

		if (pessoaMaybe.isEmpty()) {
			return 0;
		}
		DB.remove(pessoaMaybe.get());
		return 1;
	}

	@Override
	public int updatePessoaById(UUID id, Pessoa update) {
		return selectPessoaById(id)
				.map(pessoa -> {
					int indexOfPessoaToUpdate = DB.indexOf(pessoa);
					if (indexOfPessoaToUpdate >= 0) {
						DB.set(indexOfPessoaToUpdate, new Pessoa(id, update.getNome(), update.getTelefone()));
						return 1;
					}
					return 0;
				}).orElse(0);
	}

}

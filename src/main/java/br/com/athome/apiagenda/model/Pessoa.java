package br.com.athome.apiagenda.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pessoa {

	private final UUID id;
	private final String nome;
	private final String telefone;

	public Pessoa(@JsonProperty("id") UUID id, 
			@JsonProperty("nome") String nome,
			@JsonProperty("telefone") String telefone) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
	}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

}

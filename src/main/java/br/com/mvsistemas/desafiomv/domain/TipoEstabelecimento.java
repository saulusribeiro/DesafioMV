package br.com.mvsistemas.desafiomv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class TipoEstabelecimento {
	@Column(length = 80)
	@Id
	private String  tipo_estabelecimento;

	public String getTipo_estabelecimento() {
		return tipo_estabelecimento;
	}

	public void setTipo_estabelecimento(String tipo_estabelecimento) {
		this.tipo_estabelecimento = tipo_estabelecimento;
	}

		
}

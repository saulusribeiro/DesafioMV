package br.com.mvsistemas.desafiomv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class CNESAtivos {


@Id
@Column(length = 7, nullable = false)
private String codigo_cnes;
@Column(length = 6, nullable = false)
private String codigo_ibge;
@Column(length = 80, nullable = true)
private String nome_fantasia;
@ManyToOne
@JoinColumn(nullable = false)
private TipoEstabelecimento tipo_estabelecimento;
@Column(length = 1, nullable = false)
private String tipo_gestao;
@Column(length = 80, nullable = false)
private String nome_logradouro;
@Column(length = 80, nullable = true)
private String numero_endereco;
@Column(length = 50, nullable = true)
private String bairro;
@Column(length = 8, nullable = true)
private String cep;
@ManyToOne
@JoinColumn(nullable = false)
private Estado estado;
@Column(length = 50, nullable = true)
private String municipio;
@Column(length = 35, nullable = true)
private String telefone;

public String getCodigo_cnes() {
	return codigo_cnes;
}
public void setCodigo_cnes(String codigo_cnes) {
	this.codigo_cnes = codigo_cnes;
}
public String getCodigo_ibge() {
	return codigo_ibge;
}
public void setCodigo_ibge(String codigo_ibge) {
	this.codigo_ibge = codigo_ibge;
}
public String getNome_fantasia() {
	return nome_fantasia;
}
public void setNome_fantasia(String nome_fantasia) {
	this.nome_fantasia = nome_fantasia;
}
public TipoEstabelecimento getTipo_estabelecimento() {
	return tipo_estabelecimento;
}
public void setTipo_estabelecimento(TipoEstabelecimento tipo_estabelecimento) {
	this.tipo_estabelecimento = tipo_estabelecimento;
}
public String getTipo_gestao() {
	return tipo_gestao;
}
public void setTipo_gestao(String tipo_gestao) {
	this.tipo_gestao = tipo_gestao;
}
public String getNome_logradouro() {
	return nome_logradouro;
}
public void setNome_logradouro(String nome_logradouro) {
	this.nome_logradouro = nome_logradouro;
}
public String getNumero_endereco() {
	return numero_endereco;
}
public void setNumero_endereco(String numero_endereco) {
	this.numero_endereco = numero_endereco;
}
public String getBairro() {
	return bairro;
}
public void setBairro(String bairro) {
	this.bairro = bairro;
}
public String getCep() {
	return cep;
}
public void setCep(String cep) {
	this.cep = cep;
}
public Estado getEstado() {
	return estado;
}
public void setEstado(Estado estado) {
	this.estado = estado;
}
public String getMunicipio() {
	return municipio;
}
public void setMunicipio(String municipio) {
	this.municipio = municipio;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}





	
	

}

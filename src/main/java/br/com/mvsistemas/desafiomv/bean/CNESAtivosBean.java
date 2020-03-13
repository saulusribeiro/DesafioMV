package br.com.mvsistemas.desafiomv.bean;

import java.io.Serializable;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.opencsv.CSVWriter;

import br.com.mvsistemas.desafiomv.dao.CNESAtivosDAO;
import br.com.mvsistemas.desafiomv.dao.EstadoDAO;
import br.com.mvsistemas.desafiomv.dao.TipoEstabelecimentoDAO;
import br.com.mvsistemas.desafiomv.domain.CNESAtivos;
import br.com.mvsistemas.desafiomv.domain.Estado;
import br.com.mvsistemas.desafiomv.domain.TipoEstabelecimento;

@SuppressWarnings("serial")
@ManagedBean

public class CNESAtivosBean implements Serializable {

	private CNESAtivos cnesativos;
	private List<CNESAtivos> cnesAtivosLista;

	private Estado estado;
	private List<Estado> estados;

	private TipoEstabelecimento tipoestabelecimento;
	private List<TipoEstabelecimento> tipoestabelecimentos;

	public TipoEstabelecimento getTipoestabelecimento() {
		return tipoestabelecimento;
	}

	public void setTipoestabelecimento(TipoEstabelecimento tipoestabelecimento) {
		this.tipoestabelecimento = tipoestabelecimento;
	}

	public List<TipoEstabelecimento> getTipoestabelecimentos() {
		return tipoestabelecimentos;
	}

	public void setTipoestabelecimentos(List<TipoEstabelecimento> tipoestabelecimentos) {
		this.tipoestabelecimentos = tipoestabelecimentos;
	}

	public List<CNESAtivos> getCnesAtivosLista() {
		return cnesAtivosLista;
	}

	public void setCnesAtivosLista(List<CNESAtivos> cnesAtivosLista) {
		this.cnesAtivosLista = cnesAtivosLista;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public CNESAtivos getCnesativos() {
		return cnesativos;
	}

	public void setCnesativos(CNESAtivos cnesativos) {
		this.cnesativos = cnesativos;
	}

	public void listar() {
		try {
			CNESAtivosDAO cnesAtivosDAO = new CNESAtivosDAO();
			cnesAtivosLista = cnesAtivosDAO.listar();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro na listagem da Tabela de CNES Ativos");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void Inicializar() {
		estado = new Estado();
		tipoestabelecimento = new TipoEstabelecimento();
		cnesativos = new CNESAtivos();

		// Inicialização dos combos de seleção

		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (Exception erro) {
			Messages.addGlobalError("Erro na listagem da Tabela de Estados");
			erro.printStackTrace();
		}

		try {
			TipoEstabelecimentoDAO tipoestabelecimentoDAO = new TipoEstabelecimentoDAO();
			tipoestabelecimentos = tipoestabelecimentoDAO.listar();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro na listagem da Tabela de Estabelecimentos");
			erro.printStackTrace();
		}
	}

	public void exibir(ActionEvent evento) {

		cnesativos = (CNESAtivos) evento.getComponent().getAttributes().get("cnesselecionado");

	}
	      
	public void listarUF(ActionEvent evento) {
	

		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");

		try {

			CNESAtivosDAO cnesAtivosDAO = new CNESAtivosDAO();
			cnesAtivosLista = cnesAtivosDAO.listarEstado(estado);

		} catch (Exception erro) {

			Messages.addGlobalError("Erro na listagem da Tabela de CNES Ativos");
			erro.printStackTrace();
		}
	}

	public void listarTipo(ActionEvent evento) {

		tipoestabelecimento = (TipoEstabelecimento) evento.getComponent().getAttributes().get("tipoSelecionado");

		try {

			CNESAtivosDAO cnesAtivosDAO = new CNESAtivosDAO();
			cnesAtivosLista = cnesAtivosDAO.listarTipoEstab(tipoestabelecimento);

		} catch (Exception erro) {

			Messages.addGlobalError("Erro na listagem da Tabela de CNES Ativos");
			erro.printStackTrace();
		}
	}

	public void gerarCSV() {
		try {
			CNESAtivosDAO cnesAtivosDAO = new CNESAtivosDAO();
			cnesAtivosLista = cnesAtivosDAO.listar();

			String[] cabecalho = { "co_cnes","no_bairro", "co_cep", "co_ibge", "municipio", "no_fantasia",
					"no_logradouro", "nu_endereco", "nu_telefone", "tp_gestao", "uf", "ds_tipo_unidade" };

			List<String[]> linhas = new ArrayList<>();
			Messages.addGlobalInfo("Início da geração do CSV. Aguarde.... ");
			
			for (CNESAtivos elemento : cnesAtivosLista) {
				linhas.add(new String[] { elemento.getCodigo_cnes() + "," + elemento.getBairro() + ","
						+ elemento.getCep() + "," + elemento.getCodigo_ibge() + "," + elemento.getMunicipio() + ","
						+ elemento.getNome_fantasia() + "," + elemento.getNome_logradouro() + ","
						+ elemento.getNumero_endereco() + "," + elemento.getTelefone() + "," + elemento.getTipo_gestao()
						+ "," + elemento.getEstado().getEstado().toString() + "," 
						+ elemento.getTipo_estabelecimento().getTipo_estabelecimento().toString()} );

				Writer arquivocsv = Files.newBufferedWriter(Paths.get("c:/temp/testecnesativos.csv"));
				CSVWriter csvWriter = new CSVWriter(arquivocsv);

				csvWriter.writeNext(cabecalho);
				csvWriter.writeAll(linhas);
				Messages.addGlobalInfo("Termino com sucesso ");
				csvWriter.flush();
				arquivocsv.close();
				
			}

		} catch (Exception erro) {
			Messages.addGlobalError("Erro na geração do CSV da Tabela de CNES Ativos");
			erro.printStackTrace();
		}
	}

}

package br.com.micromap.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;

/**
 * Classe responsável por administrar o template do site
 * 
 * @author Leticia Alves
 * @since 21/11/2014
 *
 */
@SuppressWarnings("serial")
@ManagedBean(name = "MBTemplate")
@ViewScoped
public class TemplateBean implements Serializable {

	private String menuHomeSelecionado;
	private String menuSolucoesSelecionado;
	private String menuLojaSelecionado;
	private String menuAssistenciaSelecionado;
	private String menuEmpresaSelecionado;
	private String menuContatoSelecionado;
	private String menuTopdataSelecionado;
	private String indexAtual;

	/**
	 * Redefine o CSS do Menu (classe 'current-page'), e o index atual
	 */
	@PostConstruct
	public void redefinirMenu() {

		FacesContext context = FacesContext.getCurrentInstance();
		String nomePagina = context.getViewRoot().getViewId();

		switch (nomePagina) {
		case "/index.xhtml":
			this.setMenuHomeSelecionado("current-page");
			break;
		case "/solucoes.xhtml":
			this.setMenuSolucoesSelecionado("current-page");
			break;
		case "/loja.xhtml":
			this.setMenuLojaSelecionado("current-page");
			break;
		case "/assistencia.xhtml":
			this.setMenuAssistenciaSelecionado("current-page");
			break;
		case "/topdata.xhtml":
			this.setMenuTopdataSelecionado("current-page");
			break;
		case "/empresa.xhtml":
			this.setMenuEmpresaSelecionado("current-page");
			break;
		case "/contato.xhtml":
			this.setMenuContatoSelecionado("current-page");
			break;
		default:
			this.setMenuHomeSelecionado("current-page");
			break;
		}
	}

	public void irParaHome() throws IOException {
		Faces.redirect("");
	}

	public void irParaSoftware() throws IOException {
		Faces.redirect("micromap_software");
	}

	public void irParaLoja() throws IOException {
		Faces.redirect("micromap_loja");
	}

	public void irParaAssistencia() throws IOException {
		Faces.redirect("micromap_assistencia_tecnica");
	}

	public void irParaTopdata() throws IOException {
		Faces.redirect("revenda_assistencia_topdata");
	}

	public void irParaEmpresa() throws IOException {
		Faces.redirect("conheca_nossa_empresa");
	}

	public void irParaContato() throws IOException {
		Faces.redirect("entre_em_contato");
	}

	/************************************************************************************************/

	public String getMenuHomeSelecionado() {
		return menuHomeSelecionado;
	}

	public void setMenuHomeSelecionado(String menuHomeSelecionado) {
		this.menuHomeSelecionado = menuHomeSelecionado;
	}

	public String getMenuSolucoesSelecionado() {
		return menuSolucoesSelecionado;
	}

	public void setMenuSolucoesSelecionado(String menuSolucoesSelecionado) {
		this.menuSolucoesSelecionado = menuSolucoesSelecionado;
	}

	public String getMenuLojaSelecionado() {
		return menuLojaSelecionado;
	}

	public void setMenuLojaSelecionado(String menuLojaSelecionado) {
		this.menuLojaSelecionado = menuLojaSelecionado;
	}

	public String getMenuAssistenciaSelecionado() {
		return menuAssistenciaSelecionado;
	}

	public void setMenuAssistenciaSelecionado(String menuAssistenciaSelecionado) {
		this.menuAssistenciaSelecionado = menuAssistenciaSelecionado;
	}

	public String getMenuEmpresaSelecionado() {
		return menuEmpresaSelecionado;
	}

	public void setMenuEmpresaSelecionado(String menuEmpresaSelecionado) {
		this.menuEmpresaSelecionado = menuEmpresaSelecionado;
	}

	public String getMenuContatoSelecionado() {
		return menuContatoSelecionado;
	}

	public void setMenuContatoSelecionado(String menuContatoSelecionado) {
		this.menuContatoSelecionado = menuContatoSelecionado;
	}

	public String getIndexAtual() {
		return indexAtual;
	}

	public void setIndexAtual(String indexAtual) {
		this.indexAtual = indexAtual;
	}

	public String getMenuTopdataSelecionado() {
		return menuTopdataSelecionado;
	}

	public void setMenuTopdataSelecionado(String menuTopdataSelecionado) {
		this.menuTopdataSelecionado = menuTopdataSelecionado;
	}
	

}

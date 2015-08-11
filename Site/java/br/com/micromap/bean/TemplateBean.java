package br.com.micromap.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
	 * Injeção do Bean responsável por administrar o setor atual
	 * (público/privado)
	 */
	@ManagedProperty(value = "#{MBSessao}")
	private SessaoBean sessaoBean;

	/**
	 * Redefine o CSS do Menu (classe 'current-page'), e o index atual
	 */
	@PostConstruct
	public void redefinirMenu() {

		FacesContext context = FacesContext.getCurrentInstance();
		String nomePagina = context.getViewRoot().getViewId();

		if (!nomePagina.equals("/index_publico.xhtml")
				&& !nomePagina.equals("/index_privado.xhtml")) {
			if (sessaoBean.getIndex() == null) {
				System.out.println("Redirecionar para apresentação.xhtml!");
				try {
					FacesContext.getCurrentInstance().getExternalContext()
							.redirect("index.xhtml");
				} catch (IOException e) {
					// web.xml já trata o erro 404
					e.printStackTrace();
				}
			}
		}

		switch (nomePagina) {
		case "/index.xhtml":
			this.setMenuHomeSelecionado("current-page");
			sessaoBean.setIndex(nomePagina);
			this.setIndexAtual(sessaoBean.getIndex());
			break;
		case "/solucoes.xhtml":
			this.setMenuSolucoesSelecionado("current-page");
			this.setIndexAtual(sessaoBean.getIndex());
			break;
		case "/loja.xhtml":
			this.setMenuLojaSelecionado("current-page");
			sessaoBean.setIndex("/index_privado.xhtml");
			this.setIndexAtual(sessaoBean.getIndex());
			break;
		case "/assistencia.xhtml":
			this.setMenuAssistenciaSelecionado("current-page");
			this.setIndexAtual(sessaoBean.getIndex());
			break;
		case "/topdata.xhtml":
			this.setMenuTopdataSelecionado("current-page");
			this.setIndexAtual(sessaoBean.getIndex());
			break;
		case "/empresa.xhtml":
			this.setMenuEmpresaSelecionado("current-page");
			this.setIndexAtual(sessaoBean.getIndex());
			break;
		case "/contato.xhtml":
			this.setMenuContatoSelecionado("current-page");
			this.setIndexAtual(sessaoBean.getIndex());
			break;
		default:
			this.setMenuHomeSelecionado("current-page");
			this.setIndexAtual(sessaoBean.getIndex());
			break;
		}
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

	public SessaoBean getSessaoBean() {
		return sessaoBean;
	}

	public void setSessaoBean(SessaoBean sessaoBean) {
		this.sessaoBean = sessaoBean;
	}
	
	public String getMenuTopdataSelecionado() {
		return menuTopdataSelecionado;
	}
	
	public void setMenuTopdataSelecionado(String menuTopdataSelecionado) {
		this.menuTopdataSelecionado = menuTopdataSelecionado;
	}

}

package br.com.micromap.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Classe responsável por administrar o setor (público/privado)
 * 
 * @author Leticia Alves
 * @since 21/11/2014
 *
 */
@ManagedBean(name = "MBSessao")
@SessionScoped
public class SessaoBean {
	private String index;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

}

package br.com.micromap.bean;

import javax.faces.bean.ManagedBean;

import org.alfredlibrary.validadores.Email;
import org.primefaces.context.RequestContext;

import br.com.micromap.util.CommonsMail;

@ManagedBean(name = "MBContato")
public class ContatoBean {

	private String nome;
	private String email;
	private String assunto;
	private String mensagem;


	public void enviarEmail() {

		if (validarCampos()) {

			try {
				/* Envia e-mail */
				new CommonsMail().enviarEmail(getNome(), getEmail(), getAssunto(), getMensagem());

				/* Sucesso */
				org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('dlgSucesso').show();");
				limparFormulário();

				RequestContext.getCurrentInstance().update(":frmContato:pnlContato");

			} catch (Exception ex) {
				ex.printStackTrace();
				org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('dlgErro').show();");
			}

		} else {
			org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('dlgCamposInvalidos').show();");
		}

	}

	public boolean validarCampos() {
		if (nome == null || "".equals(nome))
			return false;
		if (!Email.isValido(email))
			return false;
		if (assunto == null || "".equals(assunto))
			return false;
		if (mensagem == null || "".equals(mensagem))
			return false;
		/* Se tudo deu certo */
		return true;
	}

	public void limparFormulário() {
		setNome("");
		setEmail("");
		setAssunto("");
		setMensagem("");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

//	public String getDepartamentoSelecionado() {
//		return departamentoSelecionado;
//	}
//
//	public void setDepartamentoSelecionado(String departamentoSelecionado) {
//		this.departamentoSelecionado = departamentoSelecionado;
//	}
}

package br.com.micromap.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CommonsMail {

	private Properties properties;
	private Session session;

	public CommonsMail() throws IOException {
		this.getConfigurationIntegrator();
	}

	public void getConfigurationIntegrator() {
		properties = new Properties();
		properties.put("mail.smtp.host", "server17.integrator.com.br");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"contato@micromap.com.br", "oramap82");
					}
				});
	}

	public void enviarEmail(String nomeRemetente, String emailRemetente,
			String assuntoRemetente, String departamentoRemetente,
			String mensagemRemetente) throws Exception {

		MimeMessage message = new MimeMessage(session);
		message.setSentDate(new Date());
		message.setFrom(new InternetAddress(emailRemetente));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
				"contato@micromap.com.br"));
		message.setSubject(assuntoRemetente);
		message.setText("Nome do Remetente: " + nomeRemetente
				+ "\nEmail do Remetente: " + emailRemetente
				+ "\nDepartamento: " + departamentoRemetente + "\nAssunto: "
				+ assuntoRemetente + "\nMensagem: " + mensagemRemetente);
		Transport.send(message);
	}

}

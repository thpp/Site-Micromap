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
		this.getConfiguration();
	}

	public void getConfiguration() {
		properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.host", "smtplw.com.br");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		session = Session.getInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("micromapweb", "iujlncXA9161");
			}
		});
	}

	public void enviarEmail(String nomeRemetente, String emailRemetente, String assuntoRemetente,
			String mensagemRemetente) throws Exception {

		MimeMessage message = new MimeMessage(session);
		message.setSentDate(new Date());
		message.setFrom(new InternetAddress("contato@micromap.com.br"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("contato@micromap.com.br"));
		message.setSubject(assuntoRemetente);
		message.setText("Nome do Remetente: " + nomeRemetente + "\nEmail do Remetente: " + emailRemetente
				+ "\nAssunto: " + assuntoRemetente + "\nMensagem: " + mensagemRemetente);
		
		Transport.send(message);
	}

}

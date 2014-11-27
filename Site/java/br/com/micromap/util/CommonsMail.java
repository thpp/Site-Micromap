package br.com.micromap.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class CommonsMail {

	private Properties properties;
	private Session session;

	public CommonsMail() throws IOException {
		this.getConfigurationIntegrator();// ARRUMAR AQUI
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
								"issmap@micromap.com.br", "Oramap82");
					}
				});
	}

	public void getConfigurationGmail() {
		properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"micromapweb@gmail.com", "micromap007");
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
				"leticia_borges.alves@hotmail"));
		message.setSubject(assuntoRemetente);
		message.setText("Nome do Remetente: " + nomeRemetente
				+ "\nEmail do Remetente: " + emailRemetente
				+ "\nDepartamento: " + departamentoRemetente + "\nAssunto: "
				+ assuntoRemetente + "\nMensagem: " + mensagemRemetente);
		Transport.send(message);
	}

}

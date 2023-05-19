package infraestructure.mail;

import java.util.Properties;

import domain.portsou.Observador;
import domain.portsou.ObservadorException;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Mail implements Observador {
	private final static String username = "4e62eab282296a";
	private final static String password = "6e8c8e0f81f8ec";
	private static String       host     = "smtp.mailtrap.io";

	private static Properties   props;

	public void actualizar(String datos) {
		String[]   arreglo = separarDatos(datos);

		// provide recipient's email ID
		String     to      = arreglo[3];
		// provide sender's email ID
		String     from    = "jakartafrom@example.com";
		// provide Mailtrap's username

		// provide Mailtrap's host address
		// configure Mailtrap's SMTP server details
		Properties props   = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "2525");
		// create the Session object
		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// create a MimeMessage object
			Message message = new MimeMessage(session);
			// set From email field
			message.setFrom(new InternetAddress(from));
			// set To email field
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// set email subject field
			message.setSubject("Here comes Jakarta Mail!");
			// set the content of the email message
			message.setText("Inscripcion finalizada.");
			// send the email message
			Transport.send(message);
			System.out.println("Email Message Sent Successfully");
		} catch (MessagingException e) {
			throw new ObservadorException("ERROR: No fue posible enviar el email.");
		}

	}

	private String[] separarDatos(String datos) {

		String   separados[] = datos.split("\\|");

		String[] arreglo     = { separados[0], separados[1], separados[2], separados[3] };

		return arreglo;

	}

}

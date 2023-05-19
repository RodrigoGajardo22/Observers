package main;

import java.util.List;

import domain.model.SujetoUsuario;
import domain.portsin.Usuarios;
import domain.portsou.Observador;
import infraestructure.data.JdbcParticipantes;
import infraestructure.mail.Mail;
import infraestructure.ui.UI;

public class Main {

	public static void main(String[] args) {

		Observador repositorio = new JdbcParticipantes();
		Observador email       = new Mail();

		Usuarios   usuarios    = new SujetoUsuario(List.of(repositorio, email));

		UI         ui          = new UI(usuarios);

	}
}

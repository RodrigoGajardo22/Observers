package domain.model;

import java.util.List;

import domain.portsin.DomainException;
import domain.portsin.Usuarios;
import domain.portsou.Observador;

//SUJETO

public class SujetoUsuario implements Usuarios {

	private List<Observador> listaDeObservadores;

	public SujetoUsuario(List<Observador> listaDeObservadores) {

		this.listaDeObservadores = listaDeObservadores;
	}

	public void agregarIObservador(Observador obs) {
		this.listaDeObservadores.add(obs);
	}

	@Override
	public void nuevoRegistro(String nombre, String tel, String region, String email) throws DomainException {

		Participante participante = new Participante(nombre, tel, region, email);

		for (Observador observador : listaDeObservadores) {
			observador.actualizar(participante.datos());
		}
	}

}

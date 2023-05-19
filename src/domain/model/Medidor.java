package domain.model;

import java.util.List;

import domain.portsin.Observador;
import domain.portsout.ClimaOnline;

//Sujeto concreto
public class Medidor extends Sujeto {
	private String      temperatura;
	private ClimaOnline clima;

	public Medidor(List<Observador> listaObservadores, ClimaOnline clima) {
		super(listaObservadores);
		this.clima = clima;
	}

	public String leerTemperatura() {
		// leo la temperatura del servicio web
		this.temperatura = this.clima.temperatura();
		this.notificar(clima.pronostico(), temperatura);
		return this.temperatura;
	}
}

package domain.model;

import java.util.ArrayList;
import java.util.List;

import domain.portsin.Observers;

//Observable

public abstract class Sujeto {

	private List<Observers> observadores;

	public Sujeto() {
		this.observadores = new ArrayList<Observers>();
	}

	public void addObservers(Observers obs) {
		this.observadores.add(obs);
	}

	protected void notificar(String monto) {
		for (Observers obs : observadores) {
			obs.mostrar(monto);
		}

	}
}

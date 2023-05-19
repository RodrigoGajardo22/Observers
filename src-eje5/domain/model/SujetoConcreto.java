package domain.model;

import java.util.List;

import domain.portsin.Observers;

public class SujetoConcreto extends Sujeto {

	private int monto;

	public SujetoConcreto(int monto, List<Observers> observadores) {
		this.monto = monto;
		for (Observers obs : observadores) {
			this.addObservers(obs);
		}
	}

	public void facturar(int saldo) {
		this.monto += saldo;
		this.notificar("" + monto);
	}

}

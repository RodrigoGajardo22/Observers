package tarjetas;

import domain.portsin.ITarjeta;

public class Tarjeta implements ITarjeta {
//Atributos

	protected int propina;

	public Tarjeta(int propina) {

		this.propina = propina;
	}

	public float calculo(float montoBebidas, float montoPlatos) {

		float monto = montoBebidas + montoPlatos;
		return monto + monto * propina / 100;

	}

	public String toString() {
		return "OTRAS";
	}
}

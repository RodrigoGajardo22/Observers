package infraestructure.data;

import domain.portsin.Observador;

public class PorConsola implements Observador {

	@Override
	public void actualizar(String pronostico, String temperatura) {
		System.out.println(pronostico + " Grados:" + temperatura);

		float temp = Float.parseFloat(temperatura);
		if (temp < 12)
			System.out.println("Hace frio, se encendera la caldera.");
		if (temp > 17)
			System.out.println("Hace calor, se encendera el aire acondicionado.");

	}

}

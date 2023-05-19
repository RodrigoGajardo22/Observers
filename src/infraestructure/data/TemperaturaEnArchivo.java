package infraestructure.data;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;

import domain.portsin.Observador;
import domain.portsin.ObservadorException;

public class TemperaturaEnArchivo implements Observador {

	private String ruta;

	public TemperaturaEnArchivo(String ruta) {

		this.ruta = ruta;

	}

	public void actualizar(String pronostico, String temperatura) {

		try {

			File       archivo  = new File(ruta);
			FileWriter escribir = new FileWriter(archivo, true);

			escribir.write(temperatura + " " + pronostico + " Fecha: " + LocalDate.now());
			escribir.write("\r\n");
			escribir.close();
		} // Si existe un problema al escribir cae aqui
		catch (Exception e) {
			throw new ObservadorException(e, "Error al escribir en el archivo");
		}

	}

}

package infraestructure.data;

import java.io.File;
import java.io.FileWriter;

import domain.portsout.Registro;
import domain.portsout.RegistroException;

public class RegistrarVentaEnArchivo implements Registro {

	private String ruta;

	public RegistrarVentaEnArchivo(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public void registrar(String dato) {

		try {

			File       archivo  = new File(ruta);
			FileWriter escribir = new FileWriter(archivo, true);

			escribir.write(dato);
			escribir.write("\r\n");
			escribir.close();
		} // Si existe un problema al escribir cae aqui
		catch (Exception e) {
			throw new RegistroException("Error al escribir");
		}

	}

}

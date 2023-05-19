package main;

import java.util.List;

import domain.model.Medidor;
import domain.portsin.Observador;
import domain.portsout.ClimaOnline;
import infraestructure.api.OpenWeather;
import infraestructure.data.PorConsola;
import infraestructure.data.TemperaturaEnArchivo;

public class Main {

	public static void main(String args[]) {

		String      ruta              = "C:\\Users\\Usuario\\Documents\\2 - UNIVERSIDAD RODRI\\Orientacion a Objetos 2\\Persistencia\\Temperatura.txt";

		// Observadores
		Observador  registroEnArchivo = new TemperaturaEnArchivo(ruta);
		Observador  enConsola         = new PorConsola();

		ClimaOnline clima             = new OpenWeather();
		Medidor     medidor           = new Medidor(List.of(registroEnArchivo, enConsola), clima);

		medidor.leerTemperatura();

	}
}

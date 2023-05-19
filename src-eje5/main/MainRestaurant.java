package main;

import java.util.ArrayList;
import java.util.List;

import domain.model.Bebida;
import domain.model.Dispositivo;
import domain.model.Plato;
import domain.portsin.IDispositivo;
import domain.portsin.ITarjeta;
import domain.portsin.Observers;
import domain.portsout.Registro;
import infraestructure.data.RegistrarVentaEnArchivo;
import tarjetas.ComarcaPlus;
import tarjetas.MasterCard;
import tarjetas.Viedma;
import tarjetas.Visa;
import ui.Facturacion;
import ui.Gerente;

public class MainRestaurant {

	public static void main(String[] args) {
		Bebida       coca           = new Bebida("Coca", 200);
		Bebida       fanta          = new Bebida("Fanta", 150);
		Bebida       sprite         = new Bebida("Sprite", 150);

		Plato        milanesas      = new Plato("Milanesas con papas", 500);
		Plato        pollo          = new Plato("Pollo a la parrilla", 600);
		Plato        empanadas      = new Plato("Empanadas", 500);

		Registro     registroPedido = new RegistrarVentaEnArchivo(
				"C:\\Users\\Usuario\\Documents\\2 - UNIVERSIDAD RODRI\\Orientacion a Objetos 2\\Persistencia\\Registro De Ventas.txt");

		List<Bebida> listaBebidas   = new ArrayList<Bebida>();
		List<Plato>  listaPlatos    = new ArrayList<Plato>();

		listaPlatos.add(empanadas);
		listaPlatos.add(milanesas);
		listaPlatos.add(pollo);

		listaBebidas.add(sprite);
		listaBebidas.add(fanta);
		listaBebidas.add(coca);

		IDispositivo   dispositivo    = new Dispositivo(new Visa(5), registroPedido, listaBebidas, listaPlatos);

//		dispositivo.agregarBebida(coca, 2);
//		dispositivo.agregarPlato(milanesas, 1);
//		dispositivo.agregarPlato(pollo, 1);
//
//		dispositivo.calculo();

		Observers      ventanaGerente = new Gerente();
		List<ITarjeta> tarjetas       = new ArrayList<ITarjeta>();
		tarjetas.add(new Visa(5));
		tarjetas.add(new ComarcaPlus(10));
		tarjetas.add(new MasterCard(30));
		tarjetas.add(new Viedma(20));

		Facturacion facturacion = new Facturacion(dispositivo, tarjetas, List.of(new Gerente()));

	}

}

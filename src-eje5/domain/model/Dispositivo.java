package domain.model;

import java.time.LocalDate;
import java.util.List;

import domain.portsin.DispositivoException;
import domain.portsin.IDispositivo;
import domain.portsin.ITarjeta;
import domain.portsin.Producto;
import domain.portsout.Registro;

public class Dispositivo implements IDispositivo {

	private ITarjeta     tarjeta;
	private List<Bebida> listaBebidas;
	private List<Plato>  listaPlatos;
	private float        montoBebida, montoPlato, monto;
	private Registro     registro;

	public Dispositivo(ITarjeta t, Registro registro, List<Bebida> listaBebidas, List<Plato> listaPlatos) {
		this.tarjeta      = t;
		montoBebida       = 0;
		montoPlato        = 0;
		this.monto        = 0;

		this.listaBebidas = listaBebidas;
		this.listaPlatos  = listaPlatos;

		this.registro     = registro;

	}

	public void seleccionarTarjeta(ITarjeta t) {
		this.tarjeta = t;

	}

	public List<Plato> platos() {
		return listaPlatos;
	}

	public List<Bebida> bebidas() {
		return listaBebidas;
	}

	public void agregarBebida(Producto producto, int cantidad) {
		montoBebida += producto.costoTotal(cantidad);

	}

	public void agregarPlato(Producto producto, int cantidad) {
		montoPlato += producto.costoTotal(cantidad);

	}

	public float calculo() {
		if (tarjeta == null)
			new DispositivoException("Debe seleccionar una tarjeta.");

		float monto = tarjeta.calculo(montoBebida, montoPlato);
//		procesarPago(LocalDate.now(), monto);
		return monto;

	}

	public float subTotal() {
		return montoBebida + montoPlato;

	}

	public void procesarPago(LocalDate fecha, float valor) {

		registro.registrar(" " + fecha + " $" + valor);
		montoBebida = 0;
		montoPlato  = 0;

	}

}

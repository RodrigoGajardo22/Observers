package domain.portsin;

import java.time.LocalDate;
import java.util.List;

import domain.model.Bebida;
import domain.model.Plato;

public interface IDispositivo {
	public void seleccionarTarjeta(ITarjeta t);

	public void agregarBebida(Producto b, int cantidad);

	public void agregarPlato(Producto p, int cantidad);

	public float calculo();

	public float subTotal();

	public List<Plato> platos();

	public List<Bebida> bebidas();

	public void procesarPago(LocalDate fecha, float valor);
}

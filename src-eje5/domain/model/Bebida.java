package domain.model;

import domain.portsin.Producto;

public class Bebida implements Producto {
	private String nombre;
	private float  valor;

	public Bebida(String n, float v) {
		this.nombre = n;
		this.valor  = v;
	}

	public float costoTotal(int cantidadDeBebidas) {
		return valor * cantidadDeBebidas;
	}

	public String mostrarDatos() {
		return nombre + " - $" + valor;
	}

	public String toString() {
		return nombre + " - $" + valor;
	}

}

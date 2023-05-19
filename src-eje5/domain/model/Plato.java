package domain.model;

import domain.portsin.Producto;

public class Plato implements Producto {

	private String nombre;
	private float  valor;

	public Plato(String n, float v) {
		this.nombre = n;
		this.valor  = v;
	}

	public float costoTotal(int cantidadDePlatos) {
		return valor * cantidadDePlatos;
	}

	public String mostrarDatos() {
		return nombre + " - $" + valor;
	}

	public String toString() {
		return nombre + " - $" + valor;
	}
}

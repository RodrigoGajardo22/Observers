package domain.model;

import domain.portsin.DomainException;

public class Participante {

	private String telefono;
	private String nombre;
	private String region;
	private String email;

	public Participante(String nombreYApellido, String telefono, String region, String email) throws DomainException {

		this.nombre   = nombreYApellido;
		this.telefono = telefono;
		this.region   = region;
		this.email    = email;

		validarDatos(nombre, telefono, region);

	}

	private void validarDatos(String nombre, String tel, String region) throws DomainException {
		if (nombre.equals("")) {
			throw new DomainException("Cargue su nombre");
		}
		if (telefono.equals("")) {
			throw new DomainException("Debe cargar un telefono");

		}
		if (!validarTelefono(telefono)) {
			throw new DomainException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");

		}
		if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
			throw new DomainException("Region desconocida. Las conocidas son: China, US, Europa");

		}
	}

	public boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

	public String datos() {
		if (nombre != null)
			return "" + nombre + "|" + telefono + "|" + region + "|" + email;
		else
			return "No se encontraron datos.";
	}

}

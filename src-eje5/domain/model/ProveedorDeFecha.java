package domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProveedorDeFecha {

	private LocalDateTime fechaYHora;
	private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");

	public ProveedorDeFecha() {
		fechaYHora = LocalDateTime.now();

	}

	public String getFechaYHora() {

		return formato.format(fechaYHora);
	}

}

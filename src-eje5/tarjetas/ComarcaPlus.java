package tarjetas;

public class ComarcaPlus extends Tarjeta {
	private final double descuento = 0.02;

	public ComarcaPlus(int propina) {
		super(propina);

	}

	public float calculo(float montoBebida, float montoComida) {

		float montoConDescuento = (float) ((montoBebida + montoComida) - (montoBebida + montoComida) * descuento);

		return montoConDescuento + montoConDescuento * propina / 100;
	}

	public String toString() {
		return "Comarca Plus";
	}
}

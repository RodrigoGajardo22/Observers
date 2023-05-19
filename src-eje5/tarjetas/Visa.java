package tarjetas;

public class Visa extends Tarjeta {
	private final double descuento = 0.03;

	public Visa(int propina) {
		super(propina);

	}

	public float calculo(float montoBebida, float montoComida) {

		float montoBebidaConDescuento = (float) (montoBebida - montoBebida * descuento);
		float subTotal                = montoBebidaConDescuento + montoComida;
		return subTotal + subTotal * propina / 100;
	}

	public String toString() {
		return "Visa";
	}

}

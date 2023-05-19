package tarjetas;

public class MasterCard extends Tarjeta {
	private final double descuento = 0.02;

	public MasterCard(int propina) {
		super(propina);

	}

	public float calculo(float montoBebida, float montoComida) {
		float montoComidaConDescuento = (float) (montoComida - montoComida * descuento);

		float subTotal                = montoBebida + montoComidaConDescuento;

		return subTotal + subTotal * propina / 100;
	}

	public String toString() {
		return "Master Card";
	}
}

package objetos;

public class Rectangulo extends FiguraGeometrica {
	private double semibase;
	private double semialtura;

	// FEDE2AL: sobre constructores y resize(),
	// FEDE2AL: objeciones análogas a las de Circulo
	public Rectangulo(double base, double altura, Punto centro) {
		super(centro);
		semibase = base / 2;
		semialtura = altura / 2;

	}

	public Rectangulo() { // FEDE2AL: no se testea en las pruebas
		this(0.5, 0.5, new Punto());
	}

	public void resize(double factor) {
		if (factor != 0) {
			if (factor > 0) {
				semibase *= factor;
				semialtura *= factor;
			} else {
				semibase /= -factor;
				semialtura /= -factor;
			}
		}
	}

	public double getAltura() {
		return semialtura * 2;
	}

	public double getBase() {
		return semibase * 2;
	}

	public boolean contains(Punto p) {
		if (p.getX() >= super.getCentro().getX() - semibase
				&& p.getX() <= super.getCentro().getX() + semibase
				&& p.getY() >= super.getCentro().getY() - semialtura
				&& p.getY() <= super.getCentro().getY() + semialtura)
			return true;
		return false;
		// FEDE2AL: en el Circulo, el perímetro se consideraba true,
		// FEDE2AL: pero aquí se considera false, ¿no?
	}

	public double area() {
		return semibase * 2 * semialtura * 2; // FEDE2AL: mal, será por cuatro,
												// ¿no?
	} // FEDE2AL: y si no lo has cazado en las
		// FEDE2AL: pruebas, es para cuestionarse
		// FEDE2AL: esas pruebas...

	@Override
	public Rectangulo boundingBox() {
		return this;
	}
}

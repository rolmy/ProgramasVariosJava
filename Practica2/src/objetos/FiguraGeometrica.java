package objetos;

public abstract class FiguraGeometrica {

	private Punto centro;

	// FEDE2AL: los atributos, mejor "private"
	// FEDE2AL: con "getters" y "setters" si procede

	public FiguraGeometrica(Punto c) {
		centro = c;
	}
	public FiguraGeometrica(){
		this(new Punto());
	}

	public Punto getCentro() {
		return centro;
	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	public abstract void resize(double factor);

	public abstract boolean contains(Punto p);

	public abstract double area();

	public void move(double desvioX, double desvioY) {
		// FEDE2AL: ¿por qué no mantienes los nombres de parámetros
		// FEDE2AL: de cuando declaraste el "interface"?
		centro.move(desvioX, desvioY);
	}

	public void moveTo(double x, double y) {
		centro.moveTo(x, y);
	}

	public boolean equals(FiguraGeometrica otra) { 	// FEDE2AL: no se
		return centro.equals(otra.centro); 				// testea en las
													// pruebas
	}

	// FEDE2AL: ¿dos figuras geométricas son iguales
	// FEDE2AL: si lo son sus centros?

	public double distancia(Punto otro) { 	// FEDE2AL: no se testea en las
											// pruebas
		return centro.distancia(otro);
	}
	// FEDE2AL: no, no está encajando para nada el montaje,
	// FEDE2AL: mejor lo hablamos
	
	public abstract Rectangulo boundingBox();
}

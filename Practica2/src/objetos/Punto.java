package objetos; //FEDE: los nombres de paquete suelen ser en singular
//FEDE: y algo más informativos sobre su contenido

public class Punto {
	private double x;
	private double y;

	// FEDE2AL: los atributos, mejor "private"
	// FEDE2AL: con "getters" y "setters" si procede

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Punto() {
		this(0, 0);
		// FEDE: ¿por qué no "this(0, 0);" en vez de las dos asignaciones?
	}

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void move(double despX, double despY) {
		x += despX;
		y += despY;
	}

	public void moveTo(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Punto otro) {
		return otro.x == this.x && otro.y == this.y;
	}

	public double distancia(Punto otro) {
		return Math.sqrt((x - otro.getX()) * (x - otro.getX())
				+ (y - otro.getY()) * (y - otro.getY()));
		// FEDE2AL: ¿y si "otro" no es un punto?
		// FEDE2AL: no sé, no le acabo de ver el sentido al
		// FEDE2AL: "interface" Geometria y la clase Segmento
		// FEDE2AL: en vez de simplemente tener la distancia
		// FEDE2AL: euclídea entre puntos como método de Punto
	}

}

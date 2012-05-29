package objetos;

public class Circulo extends FiguraGeometrica {
	private double radio;

	public Circulo() {
		/*
		 * radio = 0.5; super.centro = new Punto();
		 */
		this(0.5, new Punto());
		// FEDE2AL: mejor "this(0.5, new Punto());" como cuerpo
	}

	public Circulo(double r, Punto centro) {
		super(centro);
		radio = r;
		// super.centro = c; //FEDE2AL: qué feo, lo que hay que hacer es empezar
		// FEDE2AL: el constructor con "super(c);" y tener en
		// FEDE2AL: la superclase un constructor que acepte el
		// FEDE2AL: centro de la figura
	}

	public boolean contains(Punto punto) {
		if (super.getCentro().distancia(punto) <= radio)
			return true;
		return false;
	}

	// FEDE2AL: mala idea pow() para elevar al cuadrado,
	// FEDE2AL: mejor z*z que pow(z,2)

	// FEDE2AL: y, definitivamente, el código de la distancia euclídea
	// FEDE2AL: debería ir a Punto, no parece que des ningún uso razonable
	// FEDE2AL: a Geometria y Segmento

	public void resize(double factor) {
		if (factor!=0){
		if (factor < 0)
			radio /= -factor; // FEDE: interpretación "peculiar" que -2
								// FEDE: equivalga a 0.5 (y -0.5 a 2)
		else
			radio *= factor;
		}
	}

	public double getRadio() {
		return radio;
	}

	public double area() { // FEDE2AL: no se testea en las pruebas
		return Math.PI * radio * radio;
	}

	@Override
	public boolean equals(FiguraGeometrica otra) {
		if(otra.getClass().equals(this.getClass())){
			Circulo otro = (Circulo) otra;
			return radio == otro.getRadio() && super.equals(otra);
		}
		return false;
	}

	@Override
	public Rectangulo boundingBox() {
		return new Rectangulo(radio*2, radio*2, super.getCentro());
	}

	public void setRadio(double d) {
		radio=d;
		
	}

}

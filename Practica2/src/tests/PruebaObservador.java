package tests;

import objetos.Circulo;
import objetos.CirculoSeleccionable;
import objetos.Observador;
import objetos.Rectangulo;
import objetos.RectanguloSeleccionable;

public class PruebaObservador {

	public static void main(String[] args) {
		CirculoSeleccionable circ = new CirculoSeleccionable();
		RectanguloSeleccionable rect = new RectanguloSeleccionable();
		
		Observador o1 = new Observador();
		Observador o2 = new Observador();
		Observador o3 = new Observador();
		
		o1.suscribirse(circ);
		o2.suscribirse(rect);
		o3.suscribirse(circ);
		o3.suscribirse(rect);
		
		circ.moveTo(7, 5);
		rect.resize(8);
		rect.move(2, 2);
		
		o3.dejarDeSeguir(circ);
		
		circ.resize(5);
		
		o3.dejarDeSeguir(circ);
	}

}

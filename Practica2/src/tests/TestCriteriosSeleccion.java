package tests;

import static org.junit.Assert.*;

import objetos.Circulo;
import objetos.Punto;
import objetos.Rectangulo;
import objetos.SeleccionPorBoundingBox;
import objetos.SeleccionPorFigura;


import org.junit.BeforeClass;
import org.junit.Test;

public class TestCriteriosSeleccion {

	static SeleccionPorFigura f;
	static SeleccionPorBoundingBox b;
	@BeforeClass
	public static void init(){
		f = new SeleccionPorFigura();
		b = new SeleccionPorBoundingBox();
	}
	@Test
	public void testQuedaSeleccionadoFigura() {
		assertTrue(f.quedaSeleccionado(new Rectangulo(5,6,new Punto()), new Punto(2,2)));
		assertFalse(f.quedaSeleccionado(new Rectangulo(5,6,new Punto()), new Punto(12,7)));
		assertTrue(f.quedaSeleccionado(new Circulo(5,new Punto()), new Punto(2,2)));
		assertFalse(f.quedaSeleccionado(new Circulo(5,new Punto()), new Punto(5,5)));
	}

	@Test
	public void testQuedaSeleccionadoBox(){
		assertTrue(b.quedaSeleccionado(new Rectangulo(5,6, new Punto()), new Punto(2,2)));
		assertFalse(b.quedaSeleccionado(new Rectangulo(5,6,new Punto()), new Punto(12,7)));
		assertTrue(b.quedaSeleccionado(new Circulo(5,new Punto()), new Punto(5,5)));
		assertFalse(b.quedaSeleccionado(new Circulo(5,new Punto()), new Punto(5,6)));
	}
}

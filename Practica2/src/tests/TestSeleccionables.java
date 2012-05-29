package tests;

import static org.junit.Assert.*;

import objetos.CirculoSeleccionable;
import objetos.Punto;
import objetos.RectanguloSeleccionable;
import objetos.SeleccionPorBoundingBox;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestSeleccionables {

	static CirculoSeleccionable circ;
	static RectanguloSeleccionable rect;
	
	@BeforeClass
	public static void initialice(){
		circ = new CirculoSeleccionable();
		rect = new RectanguloSeleccionable();
	}
	
	@Test
	public void testCirculo() {
		assertTrue(circ.quedaSeleccionado(new Punto(0.1,0.1)));
		assertFalse(circ.quedaSeleccionado(new Punto(0.5,0.5)));
		circ.setCriterio(new SeleccionPorBoundingBox());
		assertTrue(circ.quedaSeleccionado(new Punto(0.5,0.5)));
		assertFalse(circ.quedaSeleccionado(new Punto(0.5,0.6)));
	}
	
	@Test
	public void testRectangulo() {
		assertTrue(rect.quedaSeleccionado(new Punto(0.1,0.1)));
		assertFalse(rect.quedaSeleccionado(new Punto(0.5,0.5)));
		rect.setCriterio(new SeleccionPorBoundingBox());
		assertTrue(rect.quedaSeleccionado(new Punto(0.1,0.1)));
		assertFalse(rect.quedaSeleccionado(new Punto(0.5,0.5)));
	}

}

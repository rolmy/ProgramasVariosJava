package tests;

import static org.junit.Assert.*;

import objetos.Punto;
import objetos.Rectangulo;

import org.junit.Before;
import org.junit.Test;

public class TestRectangulo {

	private Rectangulo rect;

	@Before
	public void inicializar() {
		rect = new Rectangulo(5, 7, new Punto(3, 4));
	}

	@Test
	public void testResize() {
		rect.resize(-4);
		assertEquals(rect.getAltura(), 1.75, 0);
		assertEquals(rect.getBase(), 1.25, 0);
		rect.resize(2);
		assertEquals(rect.getAltura(), 3.5, 0);
		assertEquals(rect.getBase(), 2.5, 0);
	}

	@Test
	public void testMove() {
		rect.move(2.5, 3);
		assertTrue(rect.getCentro().equals(new Punto(5.5, 7)));
		//FEDE: Infinitest me marca un error aquí:
		//FEDE:   AssertionError (expected:<objetos.Punto@12b6651>
		//FEDE:   but was:<objetos.Punto@4a5ab2>) in TestRectangulo.testMove
		//FEDE: sin embargo, la ejecución normal del test es correcta
	}

	@Test
	public void testMoveTo() {
		rect.moveTo(0,0);
		assertTrue(rect.getCentro().equals( new Punto()));
	}

	@Test
	public void testContains() {
		assertTrue(rect.contains(new Punto(1, 1.5)));
		assertFalse(rect.contains(new Punto(10, 20)));
	}

}

package tests;

//FEDE2AL: pruebas bastante pobres

//FEDE2AL: para de verdad poner a prueba los métodos
//FEDE2AL: sobre si un punto está o no dentro de una figura,
//FEDE2AL: hay que probar con puntos dentro y fuera
//FEDE2AL: de la figura, cerca y lejos de su perímetro
//FEDE2AL: y en diferentes direcciones...

//FEDE2AL: no lo repito en el otro fichero de test,
//FEDE2AL: pero espero una batería de pruebas de
//FEDE2AL: verdad en la entrega definitiva de fin
//FEDE2AL: de curso

//FEDE2AL: y, en general, al comparar números en coma
//FEDE2AL: flotante, suele tener sentido hacerlo con
//FEDE2AL: un margen de error

import static org.junit.Assert.*;

import objetos.*;

import org.junit.*;

public class TestCirculo {

	private Circulo circulo;

	@Before
	public void initialize() {
		circulo = new Circulo();
	}

	// @Test
	// public void testCirculoCreado() {
	// assertEquals(circulo.getRadio(),0,0);
	// assertTrue(circulo.getCentro().equals(new Punto()));
	// }

	@Test
	public void testEscalarCirculo() {
		circulo.resize(2);
		assertEquals(circulo.getRadio(), 1, 0);
		circulo.resize(-4);
		assertEquals(circulo.getRadio(), 0.25, 0);
		circulo.resize(5);
		assertEquals(circulo.getRadio(), 1.25, 0);
	}

	@Test
	public void testMover() {
		circulo.move(2, 4);
		assertTrue(circulo.getCentro().equals(new Punto(2, 4)));
	}
	
	@Test
	public void testMoveTo(){
		circulo.moveTo(0,0);
		assertTrue(circulo.getCentro().equals(new Punto()));
	}

	@Test
	public void testContains() {
		circulo = new Circulo(5, new Punto(2, 4));
		assertTrue(circulo.contains(new Punto(4, 3)));
		assertFalse(circulo.contains(new Punto(12, 15)));
	}
	
	@Test
	public void testArea(){
		circulo = new Circulo(2, new Punto(7,8));
		assertEquals(circulo.area(), Math.PI*2*2, 1E-10);
		assertEquals(circulo.area(), new Circulo(2, new Punto()).area(),1E-10);
	}
	
	@Test
	public void testEquals(){
		assertTrue(circulo.equals(new Circulo(0.5, new Punto())));
		assertFalse(circulo.equals(new Circulo(4,new Punto(7,8))));
		assertFalse(circulo.equals(new Rectangulo()));
	}
	
	@Test
	public void testBoundingBox(){
		circulo = new Circulo(7, new Punto(5,8));
		assertTrue(circulo.boundingBox().equals(new Rectangulo(14,14,new Punto(5,8))));
		assertFalse(circulo.boundingBox().equals(new Rectangulo()));
	}
}

package tests;

//FEDE2AL: ¿no hay un test para Segmento?

//FEDE: se hubiera agradecido una "test suite" para
//FEDE: lanzar todas las pruebas a la vez y comprobar
//FEDE: la cobertura de esas pruebas sobre el código
//FEDE: cuya validez se pretende verificar

import static org.junit.Assert.*;

import objetos.Punto;

import org.junit.Before;
import org.junit.Test;

public class TestPunto {
	private static Punto p;
	@Before
	public void init(){
		p = new Punto();
	}
	@Test
	public void testMoveTo() {
		p.moveTo(1,2);
		assertTrue(p.equals(new Punto(1,2)));
		p.moveTo(3,5);
		assertFalse(p.equals(new Punto(1,2)));
		//FEDE2AL: ¿no sería más razonable utilizar assertEquals()?
	}
	@Test
	public void testMove(){
		p.move(4, 2);
		assertTrue(p.equals(new Punto(4,2)));
		p.move(4, 2);
		assertTrue(p.equals(new Punto(8,4)));
		//FEDE2AL: los test no deben depender del orden
		//FEDE2AL: en el que se ejecuten
	}
	@Test
	public void testEquals(){
		assertTrue(new Punto(1,1).equals(new Punto(1,1)));
		assertFalse(p.equals(new Punto(5,6)));
	}
	@Test
	public void testDistancia(){
		p = new Punto(1,1);
		assertEquals(p.distancia(new Punto()), Math.sqrt(2), 1E-10);
		p = new Punto(-1,-1);
		assertEquals(p.distancia(new Punto()), Math.sqrt(2), 1E-10);
		//FEDE2AL: no, "Double.parseDouble(p.distancia(new Punto()).toString())"
		//FEDE2AL: no puede ser la mejor forma de obtener el valor numérico
		//FEDE2AL: de la distancia entre dos puntos
		
		//FEDE2AL: y 0.01 me parece un margen excesivo, entre 1E-10 y 1E-14
		//FEDE2AL: ya me parece más razonable
	}
	
	
	
}

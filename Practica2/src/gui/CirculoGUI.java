package gui;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import objetos.Circulo;
import objetos.CirculoSeleccionable;
import objetos.Punto;
import objetos.Rectangulo;

public class CirculoGUI extends FiguraGUI {

	Circulo circ;
	public CirculoGUI(){
		this(new Circulo());
	}
	public CirculoGUI(Circulo elCirc){
		circ = elCirc;
	}

	@Override
	public void dibuja(Graphics2D g) {
		Ellipse2D.Double rect2D = new Ellipse2D.Double(circ.boundingBox()
				.getCentro().getX()
				- circ.getRadio(), circ.boundingBox().getCentro().getY()
				- circ.getRadio(), circ.getRadio() * 2, circ.getRadio() * 2);
		g.draw(rect2D);
	}

	@Override
	public void resize(double factor) {
		circ.resize(factor);
	}

	@Override
	public boolean contains(Punto p) {
		return circ.contains(p);
	}

	@Override
	public double area() {
		return circ.area();
	}

	@Override
	public Rectangulo boundingBox() {
		return circ.boundingBox();
	}
	@Override
	public Punto getCentro(){
		return circ.getCentro();
	}
	@Override
	public void moveTo(double x, double y){
		circ.moveTo(x, y);
	}

}

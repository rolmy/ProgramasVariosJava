package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import objetos.Punto;
import objetos.Rectangulo;

public class RectanguloGUI extends FiguraGUI {

	private Rectangulo rect;

	public RectanguloGUI() {
		this(new Rectangulo());
	}
	public RectanguloGUI(Rectangulo elRect){
		rect= elRect;
		
	}

	public void dibuja(Graphics2D g) {
		Rectangle2D.Double rect2D = new Rectangle2D.Double((rect.getCentro()
				.getX() - rect.getBase() / 2), (rect.getCentro().getY()
				- rect.getAltura() / 2), rect.getBase(), rect.getAltura());
		g.draw(rect2D);
	}

	@Override
	public void resize(double factor) {
		rect.resize(factor);
	}

	@Override
	public boolean contains(Punto p) {
		return rect.contains(p);
	}

	@Override
	public double area() {
		return rect.area();
	}

	@Override
	public Rectangulo boundingBox() {
		return rect.boundingBox();
	}
	
	@Override
	public Punto getCentro(){
		return rect.getCentro();
	}
	@Override
	public void moveTo(double x, double y){
		rect.moveTo(x, y);
	}

}

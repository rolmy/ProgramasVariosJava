package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

import objetos.Circulo;
import objetos.CirculoSeleccionable;
import objetos.FiguraGeometrica;
import objetos.Punto;
import objetos.Rectangulo;
import objetos.RectanguloSeleccionable;
import objetos.SeleccionPorBoundingBox;
import objetos.Seleccionable;

public class ControladorSimple implements Controlador {

	public ControladorSimple(PanelDibujo lienzo, Modelo modelo, Vista ventana) {
		this.modelo = modelo;
		this.lienzo = lienzo;
		this.ventana = ventana;
	}

	private Modelo modelo;
	private PanelDibujo lienzo;
	private Vista ventana; 
	
	
	private FiguraGUI seleccionada;

	@Override
	public void creaCirculo() {
		CirculoGUI circulo = new CirculoGUI(new Circulo(Math.random() * 100,
				new Punto(Math.random() * 500, Math.random() * 200)));
		modelo.añadirFigura(circulo);
		lienzo.repaint();
		seleccionada = circulo;
		
		ventana.setSlidersValues(circulo.getCentro());
	}

	@Override
	public void creaRect() {
		RectanguloGUI rect = new RectanguloGUI(new Rectangulo(
				Math.random() * 200, Math.random() * 200, new Punto(
						Math.random() * 500, Math.random() * 200)));
		modelo.añadirFigura(rect);
		lienzo.repaint();
		seleccionada = rect;
		ventana.setSlidersValues(rect.getCentro());


	}

	@Override
	public void mueveX(double nuevaPos) {
		if (seleccionada != null) {
			int i = modelo.getContenedor().indexOf(seleccionada);
			modelo.getContenedor().get(i)
					.moveTo(nuevaPos, seleccionada.getCentro().getY());
			lienzo.repaint();
			System.out.println("[" + seleccionada.getCentro().getX()
					+ "," + seleccionada.getCentro().getY() + "]");
		}
		ventana.setSlidersValues(seleccionada.getCentro());
	}

	@Override
	public void mueveY(double nuevaPos) {
		if (seleccionada != null) {
			int i = modelo.getContenedor().indexOf(seleccionada);
			modelo.getContenedor().get(i)
					.moveTo(seleccionada.getCentro().getX(), lienzo.getHeight()-nuevaPos);
			lienzo.repaint();
			System.out.println("[" + seleccionada.getCentro().getX()
					+ "," + seleccionada.getCentro().getY() + "]");
		}
		ventana.setSlidersValues(seleccionada.getCentro());
	}

	@Override
	public void redimensiona(double factor) {
		seleccionada.resize(factor);
		lienzo.repaint();
	}
	@Override
	public void eliminar(){
		modelo.eliminarFigura(seleccionada);
		seleccionada = null;
		lienzo.repaint();
	}

	public boolean seleccionar(Punto p) {
		if(seleccionada == null){
			seleccionada = modelo.seleccionarFigura(p);
			if(seleccionada!=null){
				ventana.setSlidersValues(seleccionada.getCentro());
				lienzo.repaint();
				return true;
			}
		}
		
		else if (!seleccionada.boundingBox().contains(p)){
			seleccionada = modelo.seleccionarFigura(p);
			if(seleccionada!=null){
				ventana.setSlidersValues(seleccionada.getCentro());
				lienzo.repaint();
				return true;
				}
		}
		lienzo.repaint();
		return false;
	}
	
	public void dibujaBoundingBox(Graphics2D g2d){
		if (seleccionada != null){
			Rectangulo rect = seleccionada.boundingBox();
			Rectangle2D.Double rect2D = new Rectangle2D.Double((rect.getCentro()
					.getX() - rect.getBase() / 2)+1, (rect.getCentro().getY()
					- rect.getAltura() / 2)+1, rect.getBase(), rect.getAltura());
			g2d.setColor(Color.BLUE);
			g2d.setStroke(new BasicStroke(2));
			g2d.draw(rect2D);
			g2d.setStroke(new BasicStroke(1));
			g2d.setColor(Color.BLACK);
		}
	}
	
	public boolean estaSeleccionada(){
		if(seleccionada == null)
			return false;
		return true;
	}

}

package gui;

import java.awt.Graphics2D;

import objetos.FiguraGeometrica;
import objetos.Punto;

public interface Controlador {
	public void creaCirculo();
	public void creaRect();
	public void mueveX(double nuevaPos);
	public void mueveY(double nuevaPos);
	public void redimensiona(double d);
	public boolean seleccionar(Punto p);
	public void dibujaBoundingBox(Graphics2D g2d);
	public boolean estaSeleccionada();
	public void eliminar();
}

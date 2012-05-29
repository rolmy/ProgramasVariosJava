package gui;

import java.util.List;

import gui.FiguraGUI;
import objetos.Punto;

public interface Modelo {
	void a�adirFigura(FiguraGUI f);
	void eliminarFigura(FiguraGUI f);
	public FiguraGUI seleccionarFigura(Punto p);
	List<FiguraGUI> getContenedor();
}

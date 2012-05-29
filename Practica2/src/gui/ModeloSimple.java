package gui;

import java.util.ArrayList;
import java.util.List;
import gui.FiguraGUI;
import objetos.Punto;


public class ModeloSimple implements Modelo{
	List<FiguraGUI> figuras;
	
	public ModeloSimple(){
		figuras = new ArrayList<FiguraGUI>();
	}

	@Override
	public void añadirFigura(FiguraGUI f) {
		figuras.add(f);		
	}

	@Override
	public void eliminarFigura(FiguraGUI f) {
		figuras.remove(f);
	}
	
	@Override
	public FiguraGUI seleccionarFigura(Punto p){
		for(int i = 0; i < figuras.size(); i++){
			if(figuras.get(i).contains(p))
				return figuras.get(i);
		}
		return null;
	}

	@Override
	public List<FiguraGUI> getContenedor() {
		return figuras;
	}
	
	
	
}

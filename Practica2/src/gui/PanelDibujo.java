package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import objetos.FiguraGeometrica;

public class PanelDibujo extends JPanel{
	
	private Modelo modelo;
	private Controlador controlador;
	
	
	public PanelDibujo(Modelo modelo2){
		modelo = modelo2;
		setLayout(null);
		setBackground(Color.WHITE);
	}
	

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		for(FiguraGUI f : modelo.getContenedor()){
			f.dibuja(g2d);
			if (controlador!=null)
				controlador.dibujaBoundingBox(g2d);
		}
	}
	
	public void añadirControlador(Controlador controlador){
		this.controlador = controlador;
	}
	
}

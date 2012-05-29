package gui;

import javax.swing.JFrame;

public class MVC {
	private static Modelo modelo;
	private static Controlador controlador;
	private static JFrame ventanaPrincipal;
	private static VentanaMultiple window;

	public static void main(String[]args){
		modelo = new ModeloSimple();
		window = new VentanaMultiple(modelo);
		controlador = new ControladorSimple(window.lienzo, modelo, window);
		window.inicializarBotones(controlador);
		window.inicializarSliderX(controlador);
		window.inicializarSliderY(controlador);
		window.inicializarMouseEvents(controlador);
		window.lienzo.añadirControlador(controlador);
		window.inicializarMouseWheelEvent(controlador);
		window.inicializarMouseMovimientoEvent(controlador);
	}
}

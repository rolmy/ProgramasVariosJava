package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import objetos.Punto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Ventana implements Vista {

	Punto pulsado = new Punto();

	public void inicializarBotones(final Controlador controlador) {
		botonCirculo
				.addActionListener(escuchadorBotones = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals("circulo")) {
							System.out.println("Has creado un circulo");
							controlador.creaCirculo();
						}
						if (e.getActionCommand().equals("rectangulo")) {
							System.out.println("Has creado un rectangulo");
							controlador.creaRect();
						}
						if(e.getActionCommand().equals("Delete")){
							controlador.eliminar();
						}
					};
				});
		botonRectangulo.addActionListener(escuchadorBotones);
		eliminador.addActionListener(escuchadorBotones);
	}

	public void inicializarSliderX(final Controlador controlador) {
		sliderX.addChangeListener(escuchadorSliderX = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (controlador.estaSeleccionada()) {
				JSlider slider = (JSlider) e.getSource();
				if (slider.getValueIsAdjusting()) {
					controlador.mueveX(slider.getValue());
					System.out.println(slider.getValue());
				}
				}
			}
		});
	}

	public void inicializarSliderY(final Controlador controlador) {
		sliderY.addChangeListener(escuchadorSliderY = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (controlador.estaSeleccionada()) {
				JSlider slider = (JSlider) e.getSource();
				if (slider.getValueIsAdjusting()) {
					controlador.mueveY(slider.getValue());
					System.out.println(slider.getValue());
				}
				}
			}
		});
	}

	public void inicializarMouseEvents(final Controlador controlador) {
		lienzo.addMouseListener(escuchadorRaton = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				controlador.seleccionar(new Punto(e.getPoint().x,
						e.getPoint().y));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("[" + e.getX() + "," + e.getY() + "]");
				controlador.seleccionar(new Punto(e.getX(), e.getY()));

			}
		});
	}

	public void inicializarMouseWheelEvent(final Controlador controlador) {
		lienzo.addMouseWheelListener(escuchadorRueda = new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (controlador.estaSeleccionada()) {
					if (e.getWheelRotation() > 0) {
						controlador.redimensiona(e.getWheelRotation() * 0.1 + 1);
					} else
						controlador.redimensiona(e.getWheelRotation() * 0.1 + 1);

				}
			}
		});

	}

	public void inicializarMouseMovimientoEvent(final Controlador controlador) {
		lienzo.addMouseMotionListener(escuchadorMovimiento = new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// if(controlador.seleccionar(new
				// Punto(e.getPoint().x,e.getPoint().y))){
				if (controlador.estaSeleccionada()) {
					controlador.mueveX(e.getPoint().x);
					controlador.mueveY(lienzo.getHeight() - e.getPoint().y);
				}

			}
		});
	}

	public Ventana(Modelo modelo) {
		crearVentana(modelo);
	}

	// Definicion Listeners
	ActionListener escuchadorBotones;
	ChangeListener escuchadorSliderX;
	ChangeListener escuchadorSliderY;
	MouseListener escuchadorRaton;
	ChangeListener escuchadorSliderSize;
	MouseWheelListener escuchadorRueda;
	MouseMotionListener escuchadorMovimiento;

	// Definici�n elementos ventana gr�fica
	static JButton botonCirculo;
	static JButton botonRectangulo;
	static JButton eliminador;
	static PanelDibujo lienzo;
	static JPanel panelDibujo;
	static JSlider sliderX;
	static JSlider sliderY;
	static JSlider sliderSize;

	public static JFrame crearVentana(Modelo modelo) {
		JFrame ventana = new JFrame("Probando");

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println("no tenemos Nimbus look'n feel!");
		}
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);

		panelDibujo = new JPanel();
		ventana.getContentPane().add(panelDibujo, BorderLayout.CENTER);
		panelDibujo.setLayout(new BorderLayout(20, 20));

		lienzo = new PanelDibujo(modelo);
		lienzo.setSize(615, 511);
		panelDibujo.add(lienzo, BorderLayout.CENTER);
		// lienzo.setBackground(Color.WHITE);

		JPanel panelX = new JPanel();
		panelDibujo.add(panelX, BorderLayout.NORTH);
		panelX.setLayout(new BorderLayout(20, 20));

		JLabel etiquetaX = new JLabel(" Mover");
		panelX.add(etiquetaX, BorderLayout.WEST);

		sliderX = new JSlider(0, lienzo.getWidth());
		panelX.add(sliderX);
		sliderX.setMinorTickSpacing(10);
		sliderX.setMajorTickSpacing(20);
		sliderX.setValue(0);
		sliderX.setPaintTicks(true);

		JPanel panelY = new JPanel();
		panelDibujo.add(panelY, BorderLayout.WEST);
		panelY.setLayout(new BorderLayout(20, 20));
		// JLabel etiquetaY = new JLabel("Mover Y");
		// panelY.add(etiquetaY, BorderLayout.NORTH);
		sliderY = new JSlider(0, lienzo.getHeight());
		sliderY.setValue(lienzo.getHeight());
		panelY.add(sliderY);
		sliderY.setMinorTickSpacing(10);
		sliderY.setMajorTickSpacing(20);
		sliderY.setPaintTicks(true);
		sliderY.setOrientation(SwingConstants.VERTICAL);
		// JPanel panelBarraSize = new JPanel();
		// panelDibujo.add(panelBarraSize, BorderLayout.SOUTH);
		// panelBarraSize.setLayout(new BorderLayout(20, 20));
		// JLabel etiquetaSize = new JLabel("   Redimensionar");
		// etiquetaSize.setVerticalAlignment(SwingConstants.TOP);
		// etiquetaSize.setHorizontalAlignment(SwingConstants.CENTER);
		// panelBarraSize.add(etiquetaSize, BorderLayout.WEST);
		// sliderSize= new JSlider(-2,2);
		// sliderSize.setMinorTickSpacing(1);
		// sliderSize.setMajorTickSpacing(2);
		// sliderSize.setPaintTicks(true);
		// sliderSize.setValue(0);
		// panelBarraSize.add(sliderSize);
		JPanel panelComandos = new JPanel();
		panelComandos.setLayout(new GridLayout(10, 1, 10, 20));
		ventana.getContentPane().add(panelComandos, BorderLayout.EAST);

		// panel1.setSize(700, 700);

		botonCirculo = new JButton("Crear c�rculo");
		panelComandos.add(botonCirculo);
		botonCirculo.setActionCommand("circulo");
		botonRectangulo = new JButton("Crear rect�ngulo");
		botonRectangulo.setActionCommand("rectangulo");
		panelComandos.add(botonRectangulo);
		eliminador = new JButton("Eliminar");
		eliminador.setActionCommand("Delete");
		panelComandos.add(eliminador);
		
		
		ventana.setSize(800, 600);
		ventana.setResizable(false);
		return ventana;
	}

	public void setSlidersValues(Punto centro) {
		sliderX.setValue((int) centro.getX());
		sliderY.setValue(lienzo.getHeight() - (int) centro.getY());

	}

	public void resetSliderSize() {
		sliderSize.setValue(0);

	}

}
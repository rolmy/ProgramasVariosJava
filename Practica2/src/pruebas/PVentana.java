package pruebas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PVentana extends JFrame {

	public class Lienzo extends JPanel {
		public Lienzo() {
			super();
			//setLayout(null);
			setBackground(Color.WHITE);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(Color.WHITE);
			g2d.drawLine(0, getHeight(), getWidth(), 0);
		}

	}

	public PVentana() {
		Lienzo principal = new Lienzo();
		getContentPane().setSize(800, 600);
		getContentPane().add(principal);
		
	}

	public static void main(String[] args) {
		PVentana window = new PVentana();
		window.setVisible(true);
		

	}

}

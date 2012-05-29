package objetos;

public class pruebas {

	public static void main(String[] args) {
		Punto p = new Punto();
		Punto p2 = new Punto(0,0);
		System.out.println(p.getX()==p2.getX() && p.getY() == p2.getY());
	}

}

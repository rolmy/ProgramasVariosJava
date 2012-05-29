package objetos;

public class EventoCambioPosicion {
	Observable loQueSeMira;
	Punto p;
	public EventoCambioPosicion(Observable loQueSeMira, Punto p) {
		this.loQueSeMira = loQueSeMira;
		this.p = p;
	}
	public Observable getLoQueSeMira() {
		return loQueSeMira;
	}
	public void setLoQueSeMira(Observable loQueSeMira) {
		this.loQueSeMira = loQueSeMira;
	}
	public Punto getP() {
		return p;
	}
	public void setP(Punto p) {
		this.p = p;
	}
}

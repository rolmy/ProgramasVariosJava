package objetos;

public interface Observable {
	
	void notificarTama�oObservadores(double factor);
	
	void notificarPosicionObservadores(Punto p);
	
	public void a�adirObservador(Observador miron);
	
	public void eliminarObservador(Observador miron);
	
}

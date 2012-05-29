package objetos;

public interface Observable {
	
	void notificarTamañoObservadores(double factor);
	
	void notificarPosicionObservadores(Punto p);
	
	public void añadirObservador(Observador miron);
	
	public void eliminarObservador(Observador miron);
	
}

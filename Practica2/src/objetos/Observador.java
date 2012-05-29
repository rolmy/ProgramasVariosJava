package objetos;

public  class Observador implements ObservarTamaño, ObservarPosicion{
	
	
	public void suscribirse(Observable obser){
		obser.añadirObservador(this);
	}
	
	public void dejarDeSeguir(Observable obser){
		obser.eliminarObservador(this);
	}

	@Override
	public void notificarCambioTamaño(EventoCambioTamaño event) {
		System.out.println("Soy " + this + " y he recibido el cambio de tamaño correspondiente a "+ event.getLoQueSeMira()+ " de factor "+ event.getFactor());
	}

	@Override
	public void notificarCambioPosicion(EventoCambioPosicion event) {
		System.out.println(this + " notifica cambio posición de: "+ event.getLoQueSeMira()+ " al nuevo valor: "+ event.getP());
		
	}
	
	
}

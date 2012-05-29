package objetos;

public  class Observador implements ObservarTama�o, ObservarPosicion{
	
	
	public void suscribirse(Observable obser){
		obser.a�adirObservador(this);
	}
	
	public void dejarDeSeguir(Observable obser){
		obser.eliminarObservador(this);
	}

	@Override
	public void notificarCambioTama�o(EventoCambioTama�o event) {
		System.out.println("Soy " + this + " y he recibido el cambio de tama�o correspondiente a "+ event.getLoQueSeMira()+ " de factor "+ event.getFactor());
	}

	@Override
	public void notificarCambioPosicion(EventoCambioPosicion event) {
		System.out.println(this + " notifica cambio posici�n de: "+ event.getLoQueSeMira()+ " al nuevo valor: "+ event.getP());
		
	}
	
	
}

package objetos;

import java.util.ArrayList;

public class RectanguloSeleccionable extends Rectangulo implements
		Seleccionable, Observable {
	ArrayList<Observador> observadores = new ArrayList<Observador>();
	double lastFactor;
	CriterioSeleccion criterioSelec;
	
	public RectanguloSeleccionable(){
		super();
		criterioSelec = new SeleccionPorFigura();
	}
	
	
	public RectanguloSeleccionable(CriterioSeleccion cs) {
		super();
		criterioSelec = cs;
	}

	public RectanguloSeleccionable(double base, double altura, Punto centro,
			CriterioSeleccion cs) {
		super(base, altura, centro);
		criterioSelec = cs;
	}

	public void setCriterio(CriterioSeleccion cs) {
		criterioSelec = cs;
	}

	@Override
	public boolean quedaSeleccionado(Punto p) {
		return criterioSelec.quedaSeleccionado(this, p);
	}
	
	@Override
	public void notificarTama�oObservadores(double factor) {
		for(int i = 0; i < observadores.size(); i++){
			observadores.get(i).notificarCambioTama�o(new EventoCambioTama�o(this, factor));
		}
	}
	@Override
	public void notificarPosicionObservadores(Punto p) {
		for(int i = 0; i < observadores.size(); i++){
			observadores.get(i).notificarCambioPosicion(new EventoCambioPosicion(this, p));
		}
	}

	@Override
	public void resize(double factor) {
		super.resize(factor);
		lastFactor = factor;
		notificarTama�oObservadores(factor);
	}
	@Override
	public void move(double desvioX, double desvioY) {
		super.move(desvioX, desvioY);
		notificarPosicionObservadores(super.getCentro());
	}
	@Override
	public void moveTo(double x, double y) {
		super.moveTo(x, y);
		notificarPosicionObservadores(super.getCentro());
	}
	
	@Override
	public void a�adirObservador(Observador miron) {
		observadores.add(miron);
	}

	@Override
	public void eliminarObservador(Observador miron) {
		observadores.remove(miron);
		
	}
}
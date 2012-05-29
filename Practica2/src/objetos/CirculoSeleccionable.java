package objetos;

import java.util.ArrayList;

public class CirculoSeleccionable extends Circulo implements Seleccionable, Observable {
	ArrayList<Observador> observadores = new ArrayList<Observador>();
	double lastFactor=0;
	CriterioSeleccion criterioSelec;

	public CirculoSeleccionable(){
		super();
		criterioSelec = new SeleccionPorFigura();
	}
	public CirculoSeleccionable(CriterioSeleccion cs) {
		super();
		criterioSelec = cs;
	}

	public CirculoSeleccionable(double r, Punto c, CriterioSeleccion cs) {
		super(r, c);
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
	public void notificarTamañoObservadores(double factor) {
		for(int i = 0; i < observadores.size(); i++){
			observadores.get(i).notificarCambioTamaño(new EventoCambioTamaño(this, factor));
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
		notificarTamañoObservadores(factor);
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
	public void añadirObservador(Observador miron) {
		observadores.add(miron);
	}

	@Override
	public void eliminarObservador(Observador miron) {
		observadores.remove(miron);
		
	}
}

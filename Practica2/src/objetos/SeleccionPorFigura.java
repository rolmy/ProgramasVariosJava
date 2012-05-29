package objetos;

public class SeleccionPorFigura implements CriterioSeleccion {

	@Override
	public boolean quedaSeleccionado(FiguraGeometrica objeto, Punto p) {
		return objeto.contains(p);
	}

}

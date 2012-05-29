package objetos;

public class SeleccionPorBoundingBox implements CriterioSeleccion {

	@Override
	public boolean quedaSeleccionado(FiguraGeometrica objeto, Punto p) {
		return objeto.boundingBox().contains(p);
	}



}

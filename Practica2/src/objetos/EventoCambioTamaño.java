package objetos;

public class EventoCambioTamaño {
	Observable loQueSeMira;
	Double factor;
	public EventoCambioTamaño(Observable loQueSeMira, Double factor) {
		this.loQueSeMira = loQueSeMira;
		this.factor = factor;
	}
	public Observable getLoQueSeMira() {
		return loQueSeMira;
	}
	public void setLoQueSeMira(Observable loQueSeMira) {
		this.loQueSeMira = loQueSeMira;
	}
	public Double getFactor() {
		return factor;
	}
	public void setFactor(Double factor) {
		this.factor = factor;
	}
	
	
	
}

package mundo;

public class Carro {
	private String placa;
	private int numBahia;
	private Carro siguiente;
	public Carro(String placa, int numBahia) {
		this.placa= placa;
		siguiente= null;
		this.numBahia= numBahia;
	}
	public String getPlaca() {
		return placa;
	}
	public int getNumBahia() {
		return numBahia;
	}
	public void setNumBahia(int numBahia) {
		this.numBahia = numBahia;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Carro getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Carro siguiente) {
		this.siguiente = siguiente;
	}
	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", siguiente=" + siguiente + "]";
	}
	
}

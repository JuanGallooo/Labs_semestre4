package mundo;

public class Carro {
	private String placa;
	private Carro siguiente;
	public Carro(String placa) {
		this.placa= placa;
		siguiente= null;
	}
	public String getPlaca() {
		return placa;
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

}

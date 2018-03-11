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
		if(this.siguiente != null){
			this.siguiente.setSiguiente(siguiente);
		}else{
			this.siguiente = siguiente;		
		}
	}
	
	public Carro buscarCarro(String placa){
		if(this.placa.equals(placa)){
			return this;
		}
		else if (this.siguiente!= null){
			return siguiente.buscarCarro(placa);
		}
		return null;
	}
	@Override
	public String toString() {
		return "El Carro es : " + "\n"+ " placa = " + placa + "\n"+ "En la bahia: " + numBahia;
	}
	
}

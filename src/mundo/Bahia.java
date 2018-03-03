package mundo;

import datos.Cola;
import datos.Pila;

public class Bahia {
	public Pila<Carro> pilaCarros;
	public Cola colaCarros; 

	public Bahia(String datos) {
		
	}
	public Pila<Carro> getPilaCarros() {
		return pilaCarros;
	}
	public void setPilaCarros(Pila<Carro> pilaCarros) {
		this.pilaCarros = pilaCarros;
	}
	public Cola getColaCarros() {
		return colaCarros;
	}
	public void setColaCarros(Cola colaCarros) {
		this.colaCarros = colaCarros;
	}
}

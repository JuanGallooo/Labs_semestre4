package mundo;

import datos.Cola;
import datos.Pila;

public class Bahia {
	private Pila<Carro> pilaCarros;
	private Cola colaCarros; 
	private int indiceLinea;
	private int capacidad;

	public Bahia(int capacidad, String[] datos, int indice) {
		this.capacidad=capacidad;
		indiceLinea= indice;
	}
	public int getIndiceLinea() {
		return indiceLinea;
	}
	public void setIndiceLinea(int indiceLinea) {
		this.indiceLinea = indiceLinea;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public void crearBahia() {
		
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

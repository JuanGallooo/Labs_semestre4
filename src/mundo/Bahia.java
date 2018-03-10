package mundo;

import datos.Cola;
import datos.Pila;

public class Bahia {
	private Pila<Carro> pilaCarros;
	private Pila<Carro> pilaAuxiliar;
	private Cola<Carro> colaCarros; 
	private int indiceLinea;
	private int capacidad;
	private int movimientos;
	private int numBahia;

	public Bahia(int capacidad, int indice, int numBahia) {
		this.capacidad=capacidad;
		indiceLinea= indice;
		pilaCarros= new Pila<Carro>(null, capacidad);
		pilaAuxiliar= new Pila<Carro>(null,capacidad);
		colaCarros= new Cola<Carro>(capacidad);
		movimientos=0;
		this.numBahia=numBahia;
	}

	public boolean buscarCarro(String placa) {
		boolean reporte=false;
		for (int i = 0; i < pilaCarros.getTamanoPila() && reporte!= true; i++) {
			if( pilaCarros.isEmpty() != true) {
				Carro dado= pilaCarros.pop();
				pilaAuxiliar.push(dado);
				if(dado != null && dado.getPlaca().equals(placa) == true ) reporte= true;
			}
		}
		for (int j = 0; j < pilaCarros.getTamanoPila(); j++) {
			Carro dado=pilaAuxiliar.pop();
			if( dado!=null)pilaCarros.push(dado);
		}
		return reporte;
	}
	public void sacarCarro(String placaCarro) throws Exception {
		if(pilaCarros.isEmpty()!= true) {
			boolean encontro=false;
			int contador=0;
			for (int i = 0; i < pilaCarros.getTamanoPila() && encontro!=true; i++) {
				if(pilaCarros.isEmpty()!=true) {
					Carro aux= pilaCarros.pop();
					if(aux.getPlaca().equals(placaCarro)) {
						encontro =true;
						contador++;
					}
					else {
						colaCarros.enqueue(aux);
						contador++;
					}
				}
			}
			for (int j = 0; j < colaCarros.getTamanhoMax(); j++) {
			   if( colaCarros.isEmpty()!= true) {
				   Carro dado= colaCarros.front();
				   if( dado != null)pilaCarros.push(dado);
				   colaCarros.dequeue();
			   }
			}
			movimientos+=contador;
		}
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
	public Pila<Carro> getPilaCarros() {
		return pilaCarros;
	}
	public void setPilaCarros(Pila<Carro> pilaCarros) {
		this.pilaCarros = pilaCarros;
	}
	public Cola<Carro> getColaCarros() {
		return colaCarros;
	}
	public void setColaCarros(Cola<Carro> colaCarros) {
		this.colaCarros = colaCarros;
	}
	public int getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}
	public Pila<Carro> getPilaAuxiliar() {
		return pilaAuxiliar;
	}
	public void setPilaAuxiliar(Pila<Carro> pilaAuxiliar) {
		this.pilaAuxiliar = pilaAuxiliar;
	}
	public int getNumBahia() {
		return numBahia;
	}
	public void setNumBahia(int numBahia) {
		this.numBahia = numBahia;
	}
}

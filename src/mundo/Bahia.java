package mundo;

import datos.Cola;
import datos.Pila;

public class Bahia {
	private Pila<Carro> pilaCarros;
	private Cola colaCarros; 
	private int indiceLinea;
	private int capacidad;
	private int movimientos;

	public Bahia(int capacidad, String[] datos, int indice) {
		this.capacidad=capacidad;
		indiceLinea= indice;
		pilaCarros= new Pila<Carro>(null, capacidad);
		colaCarros= new Cola(capacidad);
		movimientos=0;
	}
	public int apilarCarros(String[] datos, int numCarros){
		int numAgregado=0;
		for (int i = 0; i < capacidad && numCarros>0; i++) {
			String placa=datos[indiceLinea];
			Carro agregar= new Carro(placa);
			pilaCarros.push(agregar);
			indiceLinea++;
			numCarros--;
			numAgregado++;
		}
		return numAgregado;
	}
	public String reporteCarrosApilados() {
		String reporte="";
		Pila<Carro> prueba= pilaCarros;
		for (int i = 0; i < pilaCarros.getTamanoPila(); i++) {
			Carro dado= prueba.pop();
			reporte+= dado.getPlaca() + "\n";
		}
		return reporte;
	}
	public boolean buscarCarro(String placa) {
		boolean reporte=false;
		Pila<Carro> prueba= pilaCarros;
		for (int i = 0; i < pilaCarros.getTamanoPila() && reporte!= true; i++) {
			if( prueba.isEmpty() != true) {
				Carro dado= prueba.pop();
				if(dado != null && dado.getPlaca().equals(placa) == true ) reporte= true;
			}
		}
		System.out.println(reporte);
		return reporte;
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
	public void sacarCarro(String placaCarro) throws Exception {
		if(pilaCarros.isEmpty()!= true) {
			boolean encontro=false;
			int contador=0;
			for (int i = 0; i < pilaCarros.getTamanoPila() && encontro!=true; i++) {
				if(pilaCarros.isEmpty()!=true) {
					Carro aux= pilaCarros.pop();
					if( aux.getPlaca().equals(placaCarro)) {
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
				   pilaCarros.push(colaCarros.front());
				   colaCarros.dequeue();
			   }
			}
			movimientos+=contador;
		}
	}
	public int getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}
	
}

package mundo;

import datos.Pila;

public class Parqueadero {
	private Pila<Bahia> pilaBahia;
	private int indiceLinea;
	
	public Parqueadero(int indice) {
		indiceLinea= indice;
	}
	public void crearBahias(String[] datos, String[] info) {
		int bahias= Integer.parseInt(datos[0]);
		int capacidad= Integer.parseInt(datos[1]);
		int numCarros=Integer.parseInt(datos[2]);
		pilaBahia= new Pila<Bahia>(null,bahias);
		for (int j = 0; j < bahias; j++) {
			Bahia nuevaBahia= new Bahia(capacidad,info,indiceLinea);
			pilaBahia.push(nuevaBahia);
		}
	}
	
}

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
		int numCarros= Integer.parseInt(datos[2]);
		pilaBahia= new Pila<Bahia>(null,bahias);
		for (int j = 0; j < bahias; j++) {
			Bahia nuevaBahia= new Bahia(capacidad,info,indiceLinea);
			if( numCarros>0) {
			numCarros-=nuevaBahia.apilarCarros(datos, numCarros);
			}
			indiceLinea= nuevaBahia.getIndiceLinea();
			pilaBahia.push(nuevaBahia);
		}
		requerimiento(info);
	}
	public void requerimiento(String[] info) {
		String placaEliminar=info[indiceLinea];
		indiceLinea++;
	}
	public int buscarCarroBahia(int bahiaBase,Pila<Bahia> pila,String placaCarro) {
		int bahiaEncontrada=-1;
		if(pila.isEmpty()!= true) {
			Pila<Bahia> prueba= pila;
			Bahia buscar=prueba.pop();
			if(buscar.buscarCarro(placaCarro)== true) {
				buscar.sacarCarro(placaCarro);
				
				return bahiaBase;
			}
			else {
				bahiaEncontrada= buscarCarroBahia(bahiaBase++,prueba,placaCarro);
			}
		}
		return bahiaEncontrada;
	}
	public String sacarCarros(Pila<Bahia> pilaDada) {
		String reporte="";
		if(pilaDada.isEmpty()== false) {
		}
		return reporte;
	}
	public void replaceBahia(Pila<Bahia> pila,int indiceARemplazar, Bahia nueva) {
		if(pila.isEmpty()!= true) {
			Pila<Bahia> prueba= pila;
			Pila<Bahia> aux= new Pila<Bahia>(null, prueba.getTamanoPila());
			boolean encontro=false;
			for (int i = 0; i < prueba.getTamanoPila() && encontro==false; i++) {
				if(i==indiceARemplazar) {
					prueba.pop();
					prueba.push(nueva);
					//llenar con aux
				}
				else {
					
				}
			}
		}
	}
}

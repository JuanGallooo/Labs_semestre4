package mundo;

import datos.Pila;

public class Parqueadero {
	private Pila<Bahia> pilaBahia;
	private int indiceLinea;
	
	public Parqueadero(int indice) {
		indiceLinea= indice;
	}
	public void crearBahias(String[] datos, String[] info) throws Exception {
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
		for (int i = 0; i < numCarros; i++) {
			requerimiento(info);
			indiceLinea++;
		}
	}
	public void requerimiento(String[] info) throws Exception {
		String placaEliminar=info[indiceLinea];
		buscarCarroBahia(0,pilaBahia,placaEliminar);
	}
	public int buscarCarroBahia(int bahiaBase,Pila<Bahia> pila,String placaCarro) throws Exception {
		int bahiaEncontrada=-1;
		if(pila.isEmpty()!= true) {
			Pila<Bahia> prueba= pila;
			Bahia buscar=prueba.pop();
			if(buscar.buscarCarro(placaCarro)== true) {
				buscar.sacarCarro(placaCarro);
				replaceBahia(bahiaBase,buscar);
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
	public void replaceBahia(int indiceARemplazar, Bahia nueva) {
		if(pilaBahia.isEmpty()!= false) {
			Pila<Bahia> aux= new Pila<Bahia>(null, pilaBahia.getTamanoPila());
			boolean encontro=false;
			for (int i = 0; i < pilaBahia.getTamanoPila() && encontro!=true; i++) {
				if(i==indiceARemplazar && pilaBahia.isEmpty()!=true) {
					pilaBahia.pop();
					pilaBahia.push(nueva);
					encontro=true;
				}
				else {
					aux.push(pilaBahia.pop());
				}
			}
			for (int j = 0; j < aux.getTamanoPila() && aux.isEmpty()!=false; j++) {
				pilaBahia.push(aux.pop());
			}
		}
	}
	public Pila<Bahia> getPilaBahia() {
		return pilaBahia;
	}
	public void setPilaBahia(Pila<Bahia> pilaBahia) {
		this.pilaBahia = pilaBahia;
	}
	public int getIndiceLinea() {
		return indiceLinea;
	}
	public void setIndiceLinea(int indiceLinea) {
		this.indiceLinea = indiceLinea;
	}
}

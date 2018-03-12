package mundo;

import datos.HashTable;

public class Parqueadero {
	private Bahia[] bahias;
	private HashTable directorio;
	private int indiceLinea;
	
	public Parqueadero(int indice) {
		indiceLinea= indice;
	}
	public void crearBahias(String[] datos, String[] info) throws Exception {
		int numBahias= Integer.parseInt(datos[0]);
		int capacidad= Integer.parseInt(datos[1]);
		int numCarros= Integer.parseInt(datos[2]);
		bahias= new Bahia[numBahias];
		directorio = new HashTable(numCarros);
		for (int j = 0; j < numBahias; j++) {
			Bahia nuevaBahia= new Bahia(capacidad,indiceLinea,j);
			if( numCarros>0) {
				for (int i = 0; i < capacidad && numCarros>0; i++) {
					String placa=info[nuevaBahia.getIndiceLinea()];
					Carro agregar= new Carro(placa,j);
					directorio.addToTable(agregar);
					nuevaBahia.getPilaCarros().push(agregar);
					nuevaBahia.setIndiceLinea(nuevaBahia.getIndiceLinea()+1);
					numCarros--;
				}
			}
			indiceLinea= nuevaBahia.getIndiceLinea();
			bahias[j]= nuevaBahia;
		}
	}
	public void requerimiento(String[] datos,String[] info) throws Exception {
		int numCarros= Integer.parseInt(datos[2]);
		for (int i = 0; i < numCarros; i++) {
			String placaEliminar=info[indiceLinea];
//			int bahiaEncontrada=buscarCarroBahia(placaEliminar);
//			sacarCarro(placaEliminar, bahiaEncontrada);
			sacarCarro(placaEliminar, buscarCarro(placaEliminar).getNumBahia());
			indiceLinea++;
		}
	}

	public int buscarCarroBahia(String placaCarro) throws Exception {
		int retorno=-1;
		for (int i = 0; i < bahias.length; i++) {
			if(bahias[i].getPilaCarros().isEmpty()!= true) {
				if(bahias[i].buscarCarro(placaCarro)== true) {
				retorno=i;
			    }
			}
		}
		return retorno;
	}
	
	public Carro buscarCarro(String placa){
		Carro buscado = new Carro(placa,0);
		buscado = directorio.get(buscado);
		return buscado;
	}
	public void sacarCarro(String placaSacar, int numBahia) throws Exception {
		bahias[numBahia].sacarCarro(placaSacar);
	}
	public String darReporteCarrosSacados() {
		String reporte= "";
		for (int i = 0; i < bahias.length; i++) {
			reporte+= bahias[i].getMovimientos() + " ";
		}
		return reporte;
	}

	public int getIndiceLinea() {
		return indiceLinea;
	}
	public void setIndiceLinea(int indiceLinea) {
		this.indiceLinea = indiceLinea;
	}
	public Bahia[] getBahias() {
		return bahias;
	}
	public void setBahias(Bahia[] bahias) {
		this.bahias = bahias;
	}
}

package mundo;

public class Parqueadero {
	private Bahia[] bahias;
	private int indiceLinea;
	
	public Parqueadero(int indice) {
		indiceLinea= indice;
	}
	public void crearBahias(String[] datos, String[] info) throws Exception {
		int numBahias= Integer.parseInt(datos[0]);
		int capacidad= Integer.parseInt(datos[1]);
		int numCarros= Integer.parseInt(datos[2]);
		bahias= new Bahia[numBahias];
		for (int j = 0; j < numBahias; j++) {
			Bahia nuevaBahia= new Bahia(capacidad,info,indiceLinea,j);
			if( numCarros>0) {
			numCarros-=nuevaBahia.apilarCarros(info, numCarros);
			}
			indiceLinea= nuevaBahia.getIndiceLinea();
			bahias[j]= nuevaBahia;
		}
		numCarros= Integer.parseInt(datos[2]);
		for (int i = 0; i < numCarros; i++) {
			requerimiento(info);
			indiceLinea++;
		}
	}
	public void requerimiento(String[] info) throws Exception {
		String placaEliminar=info[indiceLinea];
		buscarCarroBahia(placaEliminar);
	}
//	public int buscarCarroBahia(int bahiaBase,Pila<Bahia> pila,String placaCarro) throws Exception {
//		int bahiaEncontrada=-1;
//		if(pila.isEmpty()!= true) {
//			Pila<Bahia> prueba= pila;
//			Bahia buscar=prueba.pop();
//			System.out.println(prueba.toString());
//			contador++;
//			if(buscar.buscarCarro(placaCarro)== true) {
//				
//				System.out.println(buscar.toString()+ contador);
//
//				buscar.sacarCarro(placaCarro);
//				replaceBahia(bahiaBase,buscar);
//				return bahiaBase;
//			}
//			else {
//				bahiaEncontrada= buscarCarroBahia(bahiaBase++,prueba,placaCarro);
//			}
//		}
//		return bahiaEncontrada;
//	}
	public int buscarCarroBahia(String placaCarro) throws Exception {
		int retorno=-1;
		for (int i = 0; i < bahias.length; i++) {
			if(bahias[i].getPilaCarros().isEmpty()!= true) {
				if(bahias[i].buscarCarro(placaCarro)== true) {
				sacarCarro(placaCarro, i);
				retorno=i;
			    }
			}
		}
		return retorno;
	}
	public void sacarCarro(String placaSacar, int numBahia) throws Exception {
		bahias[numBahia].sacarCarro(placaSacar);
	}
	public String sacarCarros() {
		String reporte= "";
		for (int i = 0; i < bahias.length; i++) {
			reporte+= bahias[i].getMovimientos() + " ";
		}
		return reporte;
	}
//	public String sacarCarros(Pila<Bahia> pilaDada) {
//		String reporte="";
//		for (int i = 0; i < pilaDada.getTamanoPila() && pilaDada.isEmpty()!= true; i++) {
//			Bahia aux= pilaDada.pop();
//			reporte+= aux.getMovimientos()+ " ";
//		}
//		return reporte;
//	}
//	public void replaceBahia(int indiceARemplazar, Bahia nueva) {
//		if(pilaBahia.isEmpty()!= false) {
//			Pila<Bahia> aux= new Pila<Bahia>(null, pilaBahia.getTamanoPila());
//			boolean encontro=false;
//			for (int i = 0; i < pilaBahia.getTamanoPila() && encontro!=true; i++) {
//				if(i==indiceARemplazar && pilaBahia.isEmpty()!=true) {
//					pilaBahia.pop();
//					pilaBahia.push(nueva);
//					encontro=true;
//				}
//				else {
//					aux.push(pilaBahia.pop());
//				}
//			}
//			for (int j = 0; j < aux.getTamanoPila() && aux.isEmpty()!=false; j++) {
//				pilaBahia.push(aux.pop());
//			}
//		}
//	}
//	public Pila<Bahia> getPilaBahia() {
//		return pilaBahia;
//	}
//	public void setPilaBahia(Pila<Bahia> pilaBahia) {
//		this.pilaBahia = pilaBahia;
//	}
	public int getIndiceLinea() {
		return indiceLinea;
	}
	public void setIndiceLinea(int indiceLinea) {
		this.indiceLinea = indiceLinea;
	}
}

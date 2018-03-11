package mundo;
public class Principal {
	private Parqueadero[] casos;
	private String mensaje;
	public Principal() {
		casos= null;
		mensaje= "";
	}
	public void datosLector(String texto) throws Exception {
		String[] lineas= texto.split("\n");
	    int numCasos= Integer.parseInt(lineas[0]);
	    String[] datos= lineas[1].split(" ");
	    int indice=2;
	    casos= new Parqueadero[numCasos];
	    for (int i = 0; i < numCasos; i++) {
		 casos[i]= new Parqueadero(indice);
		 casos[i].crearBahias(datos, lineas);	 
		 casos[i].requerimiento(datos, lineas);
		 indice= casos[i].getIndiceLinea();
		 if(i+1 < numCasos) {
		 datos= lineas[indice].split(" ");
		 indice++;
		 }
		 if(i+1 == numCasos){
			 mensaje +="Salida del Caso " + (i+1) + ": " + casos[i].darReporteCarrosSacados();
		 }
		 else{
			 mensaje +="Salida del Caso " + (i+1) + ": " + casos[i].darReporteCarrosSacados() + "\n";	 
		 }
	    }
	}
	public Parqueadero[] getCasos() {
		return casos;
	}
	public void setCasos(Parqueadero[] casos) {
		this.casos = casos;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Carro buscarCarro(String placa, String indice) throws Exception{
		int caso = 0;
		try{
			caso  = Integer.parseInt(indice);	
		}
		catch(Exception e){
			throw new Exception("Existe un error en la entrada caso, asegurese que caso sea un numero y no algo diferente");
		}
		
		if(caso > casos.length || caso < 1){
			throw new Exception ("El caso que desea buscar no se encuentra en la cantidad de casos ingresados");
		}
		else{
			caso--;
			Parqueadero actual = casos[caso];
			Carro buscado = actual.buscarCarro(placa);
			return buscado;
		}
		
	
	}
}

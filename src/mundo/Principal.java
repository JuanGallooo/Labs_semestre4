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
	    for (int i = 0; i < numCasos; i++) {
		 casos[i]= new Parqueadero(indice);
		 casos[i].crearBahias(datos, lineas);	 
		 casos[i].requerimiento(datos, lineas);
		 indice= casos[i].getIndiceLinea();
		 if(i+1 < numCasos) {
		 datos= lineas[indice].split(" ");
		 indice++;
		 }
		 mensaje +="Salida "+ casos[i].darReporteCarrosSacados();
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
//	public Carro buscarCarro(String placa){
//		return actual.buscarCarro(placa);
//	}
}

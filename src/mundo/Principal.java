package mundo;
public class Principal {
	private Parqueadero actual;
	private String mensaje;
	public Principal() {
		actual= null;
	}
	public void datosLector(String texto) throws Exception {
		String[] lineas= texto.split("\n");
	    int numCasos= Integer.parseInt(lineas[0]);
	    String[] datos= lineas[1].split(" ");
	    int indice=2;
	    for (int i = 0; i < numCasos; i++) {
		 actual= new Parqueadero(indice);
		 actual.crearBahias(datos, lineas);
		 indice= actual.getIndiceLinea();
		 if(i+1 < numCasos) {
		 datos= lineas[indice].split(" ");
		 indice++;
		 }
	    }
	    mensaje ="Salida"+ actual.sacarCarros(actual.getPilaBahia());
	}
	public Parqueadero getActual() {
		return actual;
	}
	public void setActual(Parqueadero actual) {
		this.actual = actual;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}

package mundo;
public class Principal {
	private Parqueadero actual;
	
	public Principal() {
		actual= null;
	}
	public void datosLector(String texto) {
		String[] lineas= texto.split("/n");
	    int numCasos= Integer.parseInt(lineas[0]);
		int indice=2;
	    String[] datos= lineas[1].split(" ");
	    for (int i = 0; i < numCasos; i++) {
		 actual= new Parqueadero(indice);
		 actual.crearBahias(datos, lineas);
	    }
	  
	}
	public void crearNuevoMundo() {
		
	}
	public Parqueadero getActual() {
		return actual;
	}
	public void setActual(Parqueadero actual) {
		this.actual = actual;
	}
}

package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import mundo.Bahia;
import mundo.Carro;
import mundo.Parqueadero;

public class TestParqueadero {

	private Parqueadero principal;
	private String[] datos;
	private String[] info;
	
	public void escenario1() {
		principal= new Parqueadero(2);
		datos= new String[3];
		String[] auxDatos={"4","3","8"};
		datos=auxDatos;
		String[] auxInfo= {"AWMH","QNAY","7QP2","5WJ5","4Q5B","FSZ6","K75A","BC4W","K75A","5WJ5","AWMH","QNAY","BC4W","7QP2","4Q5B","FSZ6"};
		info= auxInfo;
	}
	@Test
	public void crearBahiasTest(){
		escenario1();
		try {
			int indice=7;
			principal.crearBahias(datos, info);
			assertTrue(principal.getBahias().length== Integer.parseInt(datos[0]));
			for (int i = principal.getBahias().length-1; i >=0 ; i--) {
				Bahia prueba= principal.getBahias()[i];
				assertTrue(prueba.getCapacidad()== Integer.parseInt(datos[1]));
				for (int j = 0; j < prueba.getCapacidad(); j++) {
					Carro carroPrueba=prueba.getPilaCarros().pop();
					if( carroPrueba !=null) {
					assertTrue(carroPrueba.getPlaca().equals(info[indice]));
					indice--;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
//	@Test
//	public void requerimiento(String[] info) throws Exception {
//		String placaEliminar=info[indiceLinea];
//		buscarCarroBahia(placaEliminar);
//	}
//	@Test
//	public void buscarCarroBahia(String placaCarro) throws Exception {
//		int retorno=-1;
//		for (int i = 0; i < bahias.length; i++) {
//			if(bahias[i].getPilaCarros().isEmpty()!= true) {
//				if(bahias[i].buscarCarro(placaCarro)== true) {
//				sacarCarro(placaCarro, i);
//				retorno=i;
//			    }
//			}
//		}
//		return retorno;
//	}
//	@Test
//	public void sacarCarro(String placaSacar, int numBahia) throws Exception {
//		bahias[numBahia].sacarCarro(placaSacar);
//	}
//	@Test
//	public void sacarCarros() {
//		String reporte= "";
//		for (int i = 0; i < bahias.length; i++) {
//			reporte+= bahias[i].getMovimientos() + " ";
//		}
//		return reporte;
//	}
}

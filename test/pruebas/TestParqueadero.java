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
		principal= new Parqueadero(0);
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
			fail();
		}
		
	}
	@Test
	public void requerimientoTest() {
		escenario1();
		try {
			principal.crearBahias(datos, info);
			principal.requerimiento(datos, info);
			for (int i = 0; i < principal.getBahias().length; i++) {
				Bahia prueba= principal.getBahias()[i];
			    assertTrue(prueba.getPilaCarros().isEmpty());	
			}
		} catch (Exception e) {
		    fail();
		}
	}
}

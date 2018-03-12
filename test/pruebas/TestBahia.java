package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import datos.Pila;
import mundo.Bahia;
import mundo.Carro;

public class TestBahia {
	private Bahia principal;
	
	public void escenario1() {
		principal= new Bahia(3, 0, 2);
		Pila<Carro> aux= new Pila<>(null, 3);
		try {
			aux.push(new Carro("AWMH", 0));
			aux.push(new Carro("QNAY", 0));
			aux.push(new Carro("7QP2",0));
		} catch (Exception e) {
			fail();
		}
		principal.setPilaCarros(aux);
	}
	@Test
	public void buscarCarroTest() {
		escenario1();
		String buscar="AWMH";
		try {
			boolean encontro=principal.buscarCarro(buscar);
			assertTrue(encontro);
			buscar="QNAY";
			encontro=principal.buscarCarro(buscar);
			assertTrue(encontro);
			buscar="7QP2";
			encontro=principal.buscarCarro(buscar);
			assertTrue(encontro);
			buscar="ASD4";
			encontro=principal.buscarCarro(buscar);
			assertFalse(encontro);
		} catch (Exception e) {
		}
	}
	@Test
	public void sacarCarroTest() {
		escenario1();
		String sacar="AWMH";
		try {
			principal.sacarCarro(sacar);
			assertTrue(principal.getMovimientos()== 3);
		} catch (Exception e) {
			fail();
		}
	}
}

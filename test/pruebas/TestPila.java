package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import datos.Pila;
import mundo.Carro;

public class TestPila {
	private Pila<Carro> principal;
	
	public void escenario1() {
		principal= new Pila<Carro>(null, 7);
	}
	@Test
	public void isEmptyTest() {
		escenario1();
		assertTrue(principal.isEmpty());
		Carro ejemplo= new Carro("ASD1",0);
		try {
			principal.push(ejemplo);
		} catch (Exception e) {
			fail();
		}
		assertFalse(principal.isEmpty());
	}
	@Test
	public void peekTest() {
		escenario1();
		Carro ejemplo= principal.getPrimerDato();
		assertNull(ejemplo);
		try {
			ejemplo = new Carro("SDA2", 0);
			principal.push(ejemplo);
			assertTrue(principal.peek().equals(ejemplo));
			ejemplo = new Carro("ASD4", 0);
			principal.push(ejemplo);
			ejemplo = new Carro("GDF5", 0);
			principal.push(ejemplo);
			ejemplo = new Carro("FD44", 0);
			principal.push(ejemplo);
			ejemplo = new Carro("WEQ5", 0);
			principal.push(ejemplo);
			ejemplo = new Carro("881D", 0);
			principal.push(ejemplo);
			ejemplo = new Carro("AFD2", 0);
			principal.push(ejemplo);
			assertTrue(principal.peek().equals(ejemplo));
			principal.pop();
			ejemplo = new Carro("881D", 0);
			assertTrue(principal.peek().getPlaca().equals("881D"));	
		} catch (Exception e) {
			fail();
		}
	}
	@Test
	public void pushTest() {
		escenario1();
		try {
			assertTrue(principal.isEmpty());
			Carro[] ejemplo = new Carro[principal.getTamanoPila()];
			ejemplo[0] = new Carro("SDA2", 0);
			principal.push(ejemplo[0]);
			assertTrue(principal.peek().equals(ejemplo[0]));
			ejemplo[1] = new Carro("ASD4", 0);
			principal.push(ejemplo[1]);
			ejemplo[2] = new Carro("GDF5", 0);
			principal.push(ejemplo[2]);
			ejemplo[3] = new Carro("FD44", 0);
			principal.push(ejemplo[3]);
			ejemplo[4] = new Carro("WEQ5", 0);
			principal.push(ejemplo[4]);
			ejemplo[5] = new Carro("881D", 0);
			principal.push(ejemplo[5]);
			ejemplo[6] = new Carro("AFD2", 0);
			principal.push(ejemplo[6]);
			
			try {
				principal.push(new Carro("45DS", 0));
				principal.push(new Carro("DQW1", 0));
				principal.push(new Carro("SDG3", 0));
				principal.push(new Carro("HFG5", 0));
				fail();
			} catch (Exception e) {
				assertTrue(true);
			}
			for (int i = ejemplo.length-1; i >=0; i--) {
				assertTrue(ejemplo[i].equals(principal.pop()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void popTest() {
		escenario1();
		try {
			assertTrue(principal.isEmpty());
			Carro[] ejemplo = new Carro[principal.getTamanoPila()];
			ejemplo[0] = new Carro("SDA2", 0);
			principal.push(ejemplo[0]);
			assertTrue(principal.peek().equals(ejemplo[0]));
			ejemplo[1] = new Carro("ASD4", 0);
			principal.push(ejemplo[1]);
			ejemplo[2] = new Carro("GDF5", 0);
			principal.push(ejemplo[2]);
			ejemplo[3] = new Carro("FD44", 0);
			principal.push(ejemplo[3]);
			ejemplo[4] = new Carro("WEQ5", 0);
			principal.push(ejemplo[4]);
			ejemplo[5] = new Carro("881D", 0);
			principal.push(ejemplo[5]);
			ejemplo[6] = new Carro("AFD2", 0);
			principal.push(ejemplo[6]);
			for (int i = ejemplo.length-1; i >=0; i--) {
				Carro compa= principal.pop();
				assertTrue(ejemplo[i].equals(compa));
			}
			assertTrue(principal.isEmpty());
			assertNull(principal.pop());
		} catch (Exception e) {
			fail();
		}
	}

}

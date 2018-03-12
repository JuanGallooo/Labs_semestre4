package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import datos.Cola;

public class TestCola {
	private Cola <String> prueba;
	
	
	public void escenario1(){
		prueba = new Cola <String>(5);
	}
	

	@Test
	public void enqueueTest() {
		escenario1();
		
		String uno = "ABCD";
		String dos = "EFGH";
		String tres = "IJKL";
		String cuatro = "MNOP";
		String cinco = "QRST";
		
		String base = prueba.front();
		
		assertTrue(base == null);
		
		try {
			prueba.enqueue(cinco);
			assertTrue(prueba.getBack() == 0);
			prueba.enqueue(cuatro);
			assertTrue(prueba.getBack() == 1);
			prueba.enqueue(dos);
			assertTrue(prueba.getBack() == 2);
			prueba.enqueue(uno);
			assertTrue(prueba.getBack() == 3);
			prueba.enqueue(tres);
			assertTrue(prueba.getBack() == 4);
		} catch (Exception e) {
			fail("Se deberían poder agregar todos los carro");
			
		}
		
		assertTrue(cinco.equals(prueba.front()) && tres.equals(prueba.back()));
			
		escenario1();
		try {
			prueba.enqueue(dos);
			assertTrue(prueba.getBack() == 0);
			prueba.enqueue(cuatro);
			assertTrue(prueba.getBack() == 1);
			prueba.enqueue(tres);
			assertTrue(prueba.getBack() == 2);
			prueba.enqueue(cinco);
			assertTrue(prueba.getBack() == 3);
			prueba.enqueue(uno);
			assertTrue(prueba.getBack() == 4);
		} catch (Exception e) {
			fail("Se deberían poder agregar todos los carro");
			
		}
		
		assertTrue(dos.equals(prueba.front()) && uno.equals(prueba.back()));
		
		try{
			String seis = "Exception";
			prueba.enqueue(seis);
			fail("Deberia salir una excepcion");
		}
		catch (Exception e){
			assertTrue(true);
		}
	}
	
	@Test
	public void dequeueTest(){
		escenario1();
		
		String uno = "ABCD";
		String dos = "EFGH";
		String tres = "IJKL";
		String cuatro = "MNOP";
		String cinco = "QRST";
		
		try {
			prueba.enqueue(uno);
			prueba.enqueue(dos);
			prueba.enqueue(tres);
			prueba.enqueue(cuatro);
			prueba.enqueue(cinco);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Falla la carga");
	    }
		
		assertTrue(prueba.getBack()== 4);
		assertTrue(prueba.back().equals(cinco) && prueba.front().equals(uno));
		
		prueba.dequeue();
		
		assertTrue(prueba.getBack() == 3);
		assertTrue(prueba.back().equals(cinco) && prueba.front().equals(dos));
		
		escenario1();
		
		try {
			prueba.enqueue(cinco);
			prueba.enqueue(cuatro);
			prueba.enqueue(dos);
			prueba.enqueue(tres);
			prueba.enqueue(uno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Falla la carga");
	    }
		
		assertTrue(prueba.getBack()== 4);
		assertTrue(prueba.back().equals(uno) && prueba.front().equals(cinco));
		
		prueba.dequeue();
		
		assertTrue(prueba.getBack()== 3);
		assertTrue(prueba.back().equals(uno) && prueba.front().equals(cuatro));
		
		
		escenario1();
		
		assertTrue(prueba.front() == null);
		
		try{	
			prueba.dequeue();
			assertTrue(true);
		}
		catch (Exception e){
			fail("No deberia lanzar Excepcion");
		}
		
	}
	
	@Test
	public void getBackTest(){
	escenario1();
		
		String uno = "ABCD";
		String dos = "EFGH";
		String tres = "IJKL";
		String cuatro = "MNOP";
		String cinco = "QRST";
		
		try {
			prueba.enqueue(cinco);
			prueba.enqueue(cuatro);
			prueba.enqueue(dos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Falla la carga");
	    }
		
		assertTrue(prueba.getBack() == 2);
		
		escenario1();
		
		try {
			prueba.enqueue(cinco);
			prueba.enqueue(cuatro);
			prueba.enqueue(dos);
			prueba.enqueue(tres);
			prueba.enqueue(uno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Falla la carga");
	    }
		
		assertTrue(prueba.getBack() == 4);
		
		prueba.dequeue();
		prueba.dequeue();
		prueba.dequeue();
		
		assertTrue(prueba.getBack()==1);
	}
	
	@Test
	public void backTest(){
escenario1();
		
		String uno = "ABCD";
		String dos = "EFGH";
		String tres = "IJKL";
		String cuatro = "MNOP";
		String cinco = "QRST";
		
		try {
			prueba.enqueue(cinco);
			prueba.enqueue(cuatro);
			prueba.enqueue(dos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Falla la carga");
	    }
		
		assertTrue(dos.equals(prueba.back()));
		
		
        escenario1();
		
		try {
			prueba.enqueue(cinco);
			prueba.enqueue(cuatro);
			prueba.enqueue(dos);
			prueba.enqueue(tres);
			prueba.enqueue(uno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Falla la carga");
	    }
		
		assertTrue(uno.equals(prueba.back()));
	}
	
	@Test
	public void frontTest(){
escenario1();
		
		String uno = "ABCD";
		String dos = "EFGH";
		String tres = "IJKL";
		String cuatro = "MNOP";
		String cinco = "QRST";
		
		try {
			prueba.enqueue(dos);
			prueba.enqueue(cinco);
			prueba.enqueue(cuatro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Falla la carga");
	    }
		
		assertTrue(dos.equals(prueba.front()));
		
		
        escenario1();
		
		try {
			prueba.enqueue(uno);
			prueba.enqueue(cinco);
			prueba.enqueue(cuatro);
			prueba.enqueue(dos);
			prueba.enqueue(tres);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Falla la carga");
	    }
		
		assertTrue(uno.equals(prueba.front()));
	}
	
	
	
	

}

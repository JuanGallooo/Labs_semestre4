package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import datos.HashTable;
import mundo.Carro;

public class TestHashTable {

	private HashTable table;
	
	public void escenario1(){
		table = new HashTable(30);
	}
	public void escenario2(){
		table = new HashTable(550);
	}
	
	@Test
	public void sizeTest(){
		Carro uno = new Carro("ABCD", 0);
		Carro dos = new Carro("EFGH" , 1);
		Carro tres = new Carro ("IJKL", 2);
		Carro cuatro = new Carro ("1999",3);
        Carro cinco = new Carro ("1234", 4);
        Carro seis = new Carro ("9991",5);
		
		escenario1();
		
		table.addToTable(uno);
		table.addToTable(dos);
		table.addToTable(tres);
		
		assertTrue(table.size() == 3);
		
		table.addToTable(cuatro);
		table.addToTable(cinco);
		table.addToTable(seis);
		
		assertTrue(table.size() == 6);
		
		
		escenario2();
		
		table.addToTable(uno);
		table.addToTable(dos);
		table.addToTable(tres);
		
		assertTrue(table.size() == 3);
		
		table.addToTable(cuatro);
		table.addToTable(cinco);
		table.addToTable(seis);
		
		assertTrue(table.size() == 6);	
	}
	
	@Test
	public void addToTableTest() {
		Carro uno = new Carro("ABCD", 0);
		Carro dos = new Carro("EFGH" , 1);
		Carro tres = new Carro ("IJKL", 2);
		
		//Hay una colision entre ambos.
		Carro cuatro = new Carro ("1999",3);
		Carro cinco = new Carro ("9991",4);
		//Hay una colision entre ambos si es escenario1, sino no.
		Carro seis = new Carro ("BBBA", 5);
		Carro siete = new Carro ("ABBB", 6);
		
		//Escenario de menos de 100 carros
		
		escenario1();
		table.addToTable(uno);
		table.addToTable(dos);
		table.addToTable(tres);
		
		assertTrue(table.size() == 3);
		
		table.addToTable(cuatro);
		table.addToTable(cinco);
		table .addToTable(seis);
		table.addToTable(siete);
		
		assertTrue(table.size() == 7);
		
		int key = table.hashFunctionCarsLess100(cuatro);
		int key2 = table.hashFunctionCarsLess100(cinco);
		
		assertSame(cuatro,table.getTableCarros()[key]);
		assertNotSame(cinco, table.getTableCarros()[key2]);
		assertSame(cinco, table.get(cinco));
		assertTrue(key == key2);
		
		key = table.hashFunctionCarsLess100(tres);
		assertSame(tres, table.getTableCarros()[key]);
		
		
		key = table.hashFunctionCarsLess100(seis);
		key2 = table.hashFunctionCarsLess100(siete);
		assertSame(seis, table.getTableCarros()[key]);
		assertNotSame(siete, table.getTableCarros()[key]);
		assertSame(siete,table.get(siete));
		assertTrue(key == key2);
		
		//Escenario donde hay más de 100 carros.
		escenario2();
		table.addToTable(uno);
		table.addToTable(dos);
		table.addToTable(tres);
		
		assertTrue(table.size() == 3);
		table.addToTable(cuatro);
		table.addToTable(cinco);
		table .addToTable(seis);
		table.addToTable(siete);
		
		assertTrue(table.size() == 7);
		
		key = table.hashFunctionCarsBigger100(cuatro);
		key2 = table.hashFunctionCarsBigger100(cinco);
		
		assertSame(cuatro,table.getTableCarros()[key]);
		assertNotSame(cinco, table.getTableCarros()[key2]);
		assertSame(cinco, table.get(cinco));
		assertTrue(key == key2);
		
		key = table.hashFunctionCarsBigger100(tres);
		assertSame(tres, table.getTableCarros()[key]);
		
		
		key = table.hashFunctionCarsBigger100(seis);
		key2 = table.hashFunctionCarsBigger100(siete);
		assertSame(seis, table.getTableCarros()[key]);
		assertSame(siete, table.getTableCarros()[key2]);
		assertTrue(key != key2);
		
	}
	
	public void getTest(){
		Carro uno = new Carro("ABCD", 0);
		Carro dos = new Carro("EFGH" , 1);
		Carro tres = new Carro ("IJKL", 2);
		
		//Hay una colision entre ambos.
		Carro cuatro = new Carro ("1999",3);
		Carro cinco = new Carro ("9991",4);
		//Hay una colision entre ambos si es escenario1, sino no.
		Carro seis = new Carro ("BBBA", 5);
		Carro siete = new Carro ("ABBB", 6);
		
		//Escenario de menos de 100 carros
		
		escenario1();
		table.addToTable(uno);
		table.addToTable(dos);
		table.addToTable(tres);
		
		assertTrue(table.size() == 3);
		
		table.addToTable(cuatro);
		table.addToTable(cinco);
		table .addToTable(seis);
		table.addToTable(siete);
		
		assertTrue(table.size() == 7);
		
		assertSame(cinco, table.get(cinco));
		assertSame(siete, table.get(siete));
		assertSame(uno,table.get(uno));
		
		
		//Escenario donde hay más de 100 carros.
		escenario2();
		table.addToTable(uno);
		table.addToTable(dos);
		table.addToTable(tres);
		
		assertTrue(table.size() == 3);
		table.addToTable(cuatro);
		table.addToTable(cinco);
		table .addToTable(seis);
		table.addToTable(siete);
		
		assertTrue(table.size() == 7);
		
		assertSame(dos, table.get(dos));
		assertSame(cuatro, table.get(cuatro));
		assertSame(tres,table.get(tres));
	}
	
	
	@Test
	public void hashFunctionBigger100Test(){
		escenario2();
		Carro uno = new Carro("AAAA", 0);
		Carro dos = new Carro("EFGH" , 1);
		Carro tres = new Carro ("IJKL", 2);
		
		//Hay una colision entre ambos.
		Carro cuatro = new Carro ("1999",3);
		Carro cinco = new Carro ("9991",4);
		//Hay una colision entre ambos si es escenario1, sino no.
		Carro seis = new Carro ("BBBA", 5);
		Carro siete = new Carro ("ABBB", 6);
		
		int key = table.hashFunctionCarsBigger100(uno);
		int key2 = table.hashFunctionCarsBigger100(cuatro);
		int key3 = table.hashFunctionCarsBigger100(cinco);
		int key4 = table.hashFunctionCarsBigger100(seis);
		int key5 = table.hashFunctionCarsBigger100(siete);
		
		assertTrue(key <= 375);
		assertTrue(key2 <= 375);
		assertTrue(key3 <= 375);
		assertTrue(key4 <= 375);
		assertTrue(key5 <= 375);
		
		assertTrue (key2 == key3);
		assertTrue (key4 != key5);
		
		
		
	}
	@Test
	public void hashFunctionLess100Test(){
		escenario1();
		Carro uno = new Carro("ABCD", 0);
		Carro dos = new Carro("EFGH" , 1);
		Carro tres = new Carro ("IJKL", 2);
		
		//Hay una colision entre ambos.
		Carro cuatro = new Carro ("1999",3);
		Carro cinco = new Carro ("9991",4);
		//Hay una colision entre ambos si es escenario1, sino no.
		Carro seis = new Carro ("BBBA", 5);
		Carro siete = new Carro ("ABBB", 6);
		
		int key = table.hashFunctionCarsLess100(uno);
		int key2 = table.hashFunctionCarsLess100(cuatro);
		int key3 = table.hashFunctionCarsLess100(cinco);
		int key4 = table.hashFunctionCarsLess100(seis);
		int key5 = table.hashFunctionCarsLess100(siete);
		
		assertTrue(key <= 100);
		assertTrue(key2 <= 100);
		assertTrue(key3 <= 100);
		assertTrue(key4 <= 100);
		assertTrue(key5 <= 100);
		
		assertTrue (key2 == key3);
		assertTrue (key4 == key5);
	}

	

}

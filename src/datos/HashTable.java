package datos;

import interfaces.interfazHash;
import mundo.Carro;

public class HashTable implements interfazHash<Carro>{
	
	public String[] keys;
	
	public HashTable(int Tamano){
	}
	@Override
	
	public int keySet(Carro object) {
		char keys[] =  object.getPlaca().toCharArray();
		int key = 0;
		for(int i  = 0; i < keys.length; i++){
			key += keys[i]* 2^i;
		}
		
		key =  1485 - key;
		
		
		return key;
	}

	@Override
	public Carro replace(Carro object) {
		return null;
	}

	@Override
	public String[] values() {
		return null;
	}

	@Override
	public boolean containsKey(String key) {
		return false;
	}

	@Override
	public Carro Get(String key) {
		return null;
	}

	@Override
	public Carro remove(String key) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

}

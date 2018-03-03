package datos;

import interfaces.interfazHash;
import mundo.Carro;

public class HashTable implements interfazHash<Carro>{
	
	public String[] keys;
	
	public HashTable(int Tamano){
	}
	@Override
	public String keySet(Carro object) {
		return null;
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

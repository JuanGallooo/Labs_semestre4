package datos;

import interfaces.interfazHash;
import mundo.Carro;

public class HashTable implements interfazHash<Carro>{
	
	public int[] tableBahias;
	public String[] tableCarros;
	
	public HashTable(int tamanhoUniverso){
		 
	}
	
	
	@Override
	public int keySet(Carro object) {
	
    char[] placa = object.getPlaca().toCharArray();
    int hash = 0;
    
    for(int i  = 0; i < placa.length; i++){
    	if(placa[i]>= 48 && placa[i]<=57){
    		hash+= Math.abs(placa[i]-57);
    	}
    	else{
    		hash+= Math.abs(placa[i]-90);
    	}
    }
		
		return hash;
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

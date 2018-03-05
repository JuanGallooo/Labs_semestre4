package datos;

import interfaces.interfazHash;
import mundo.Carro;

public class HashTable implements interfazHash<Carro>{

	// Este arreglo debe ser de carros?
	public String[] tableCarros;
	
	public HashTable(int tamanhoUniverso){
		 if(tamanhoUniverso > 100){
			 tableCarros = new String [375];
		 }
		 else{
			 tableCarros= new String[100];
		 }
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

	// Debo recibir la placa no? en vez del carro?.
	@Override
	public Carro Get(Carro placa) {
		int key = 0;
		if(this.size() > 100){
			key = hashFunctionCarsBigger100(placa);
		}
		else{
			key = hashFunctionCarsLess100(placa);
		}
		// Retorno el string del carro o retorno el carro?
		
		return null;
	}

	@Override
	public Carro remove(String key) {
		return null;
	}

	@Override
	public int size() {
		return tableCarros.length;
	}


	// No recibo más bien una placa para hacer una referencia del carro?
	//---------------------------------------------------------------------------------------------------------------------
	@Override
	public int hashFunctionCarsBigger100(Carro object) {	
	    char[] placa = object.getPlaca().toCharArray();
	    int hash = 0;
	    
	    for(int i  = 0; i < placa.length; i++){
	    	if(placa[i]>= 48 && placa[i]<=57){
	    		hash+= Math.abs(placa[i]-57);
	    	}
	    	else{
	    		hash+= Math.abs(placa[i]-90)*Math.pow(2,i);
	    	}
	    }
			
			return hash;
	}


	@Override
	public int hashFunctionCarsLess100(Carro object) {
		
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



}

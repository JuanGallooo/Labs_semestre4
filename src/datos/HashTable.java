package datos;

import interfaces.interfazHash;
import mundo.Carro;

public class HashTable implements interfazHash<Carro>{

	private Carro[] tableCarros;
	private int size;
	
	public HashTable(int tamanhoUniverso){
		 if(tamanhoUniverso > 100){
			 tableCarros = new Carro [376];
		 }
		 else{
			 tableCarros= new Carro[100];
		 }
	}
	
	@Override
	public Carro get(Carro buscado) {
		int key = 0;
		if(tableCarros.length> 100){
			key = hashFunctionCarsBigger100(buscado);
		}
		else{
			key = hashFunctionCarsLess100(buscado);
		}
		
		Carro retornar = null;
		if(tableCarros[key] != null){
			
			 retornar = tableCarros[key].buscarCarro(buscado.getPlaca());
		}
		else{
			retornar =  tableCarros[key];
		}

		
		return retornar;
	}
	
	public void addToTable(Carro agregar){
		int key  = 0;
	 if(tableCarros.length>100){
		 key = hashFunctionCarsBigger100(agregar);
	 }
	 else{
		 key = hashFunctionCarsLess100(agregar);
	 }
	 if(tableCarros[key] != null){
		 tableCarros[key].setSiguiente(agregar);
	 }
	 else{
		 tableCarros[key] = agregar;	 
	 }
	 size++;
		
		
	}

	@Override
	public int size() {
		return size;
	}

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
	
	public Carro[] getTableCarros(){
		return tableCarros;
	}



}

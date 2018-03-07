package datos;

import interfaces.InterfazCola;
import mundo.Carro;

public class Cola implements InterfazCola<Carro> {

	private Carro[] arreglo;
	private int back;
	private int tamanhoMax;
	
	public Cola(int tamanho){
		tamanhoMax = tamanho;
		arreglo = new Carro[tamanho];
		back  = 0;
	}	
	
	@Override
	public boolean isEmpty() {
		if(arreglo.length == 0){
			return true;
		}
		return false;
	}

	@Override
	public void enqueue(Carro c) throws Exception{
		if(isEmpty()){
			arreglo[0] = c;
		}
		else{
		  back++;
		  if(back < tamanhoMax){
			  arreglo[back] = c;
		  }
		  else{
			  throw new Exception("No se puede agregar un nuevo carro, ya se ocupa la capacidad máxima");
		  }
		}
		
		
	}

	@Override
	public void dequeue() {
		if(!isEmpty()){
			for(int i = 0; i < arreglo.length-1; i++){
			   Carro temp = arreglo[i+1];
			   arreglo[i] = temp; 
			   arreglo[i+1] = null;
			}
		}
		
	}

	@Override
	public Carro front() {
		return  arreglo[0];
	}

	@Override
	public Carro back() {
		return arreglo[back];
	}
	public int getBack() {
		return back;
	}

	public void setBack(int back) {
		this.back = back;
	}

	public int getTamanhoMax() {
		return tamanhoMax;
	}

	public void setTamanhoMax(int tamanhoMax) {
		this.tamanhoMax = tamanhoMax;
	}


}

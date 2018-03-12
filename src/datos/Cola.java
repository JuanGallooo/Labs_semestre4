package datos;

import interfaces.InterfazCola;

public class Cola<T> implements InterfazCola<T> {

	private Object[] arreglo;
	private int back;
	private int tamanhoMax;
	
	public Cola(int tamanho){
		tamanhoMax = tamanho;
		arreglo = new Object[tamanho];
		back  = 0;
	}	
	
	@Override
	public boolean isEmpty() {
		if(arreglo[0]== null){
			back=0;
			return true;
		}
		return false;
	}

	@Override
	public void enqueue(T c) throws Exception{
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

	@SuppressWarnings("unchecked")
	@Override
	public void dequeue() {
		if(!isEmpty()){
			for(int i = 0; i < arreglo.length-1; i++){
			   T temp = (T) arreglo[i+1];
			   arreglo[i] = temp; 
			   arreglo[i+1] = null;
			}
			back--;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T front() {
		return (T) arreglo[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public T back() {
		return (T)arreglo[back];
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

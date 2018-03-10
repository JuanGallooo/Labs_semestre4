package datos;

import interfaces.InterfazPila;

public class Pila<A> implements InterfazPila<A>{
	private A primerDato;
	private Object[] contenido;
	private int indice;
	private int tamanoPila;
	public Pila(A primerDato, int tamano) {
		this.primerDato = primerDato;
		contenido= new Object[tamano];
		tamanoPila= tamano;
		contenido[0]= primerDato;
		indice= 1;
    }
	
	@Override
	public boolean isEmpty() {
		Boolean retorno= false;
		if(primerDato== null) retorno= true;
		return retorno;
	}
	@SuppressWarnings("unchecked")
	@Override
	public A peek() {
		return (A)contenido[indice-1];
	}
	@Override
	public A push(A dato) throws Exception {
		if(indice<=contenido.length) {
			if( primerDato== null && dato!=null) {
				primerDato= dato;
				indice=0;
				contenido[indice]= dato;
				indice++;
			}
			else {
				contenido[indice]= dato;
				indice++;
			}
		}
		else throw new Exception("Se ha llenado la pila");
		return dato;
	}
	@SuppressWarnings("unchecked")
	@Override
	public A pop() {
		 A retorno=null;
		 if( primerDato!= null) {
		 if( indice== 1) {
			retorno= primerDato;
			primerDato= null;
		 }
		 else {
			 retorno= (A) contenido[indice-1];
			 contenido[indice-1]= null;
			 indice--;
		 }
		}
		return retorno;
	}
	public A getPrimerDato() {
		return primerDato;
	}
	public void setPrimerDato(A primerDato) {
		this.primerDato = primerDato;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public int getTamanoPila() {
		return tamanoPila;
	}

	public void setTamanoPila(int tamanoPila) {
		this.tamanoPila = tamanoPila;
	}

}

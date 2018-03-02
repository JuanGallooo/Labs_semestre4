package mundo;

public class Pila<A> implements InterfazDato<A>{
	private A primerDato;
	private Object[] contenido;
	private int indice;
	public Pila(A primerDato, int tamano) {
		this.primerDato = primerDato;
		contenido= new Object[tamano];
		contenido[0]= primerDato;
		indice= 1;
    }
	@Override
	public boolean isEmpty() {
		Boolean retorno= false;
		if(primerDato== null) retorno= true;
		return retorno;
	}
	@Override
	public A front() {
		return primerDato;
	}
	@Override
	public A back() {
		return null;
	}
	@Override
	public A push(A dato) {
		if(indice<contenido.length) {
			if( primerDato== null) {
				primerDato= dato;
				indice= 0;
				contenido[indice]= dato;
				indice++;
			}
			else {
				contenido[indice]= dato;
				indice++;
			}
		}
		else return null;
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
	public void setContenido(A[] cotenido) {
		this.contenido = cotenido;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
}

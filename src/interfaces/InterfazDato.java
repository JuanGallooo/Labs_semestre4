package interfaces;

public interface InterfazDato<T> {
	public boolean isEmpty();
	public T front();
	public T back();
	public T push(T dato);
	public T pop();
}

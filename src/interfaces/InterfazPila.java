package interfaces;

public interface InterfazPila<T> {
	public boolean isEmpty();
	public T front();
	public T push(T dato);
	public T pop();
}

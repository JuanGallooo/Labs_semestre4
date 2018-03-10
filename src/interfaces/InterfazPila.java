package interfaces;

public interface InterfazPila<T> {
	public boolean isEmpty();
	public T peek();
	public T push(T dato) throws Exception;
	public T pop();
}

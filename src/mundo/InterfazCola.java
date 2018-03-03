package mundo;

public interface InterfazCola<T> {

	public boolean isEmpty();
	public void enqueue(T c) throws Exception;
	public void dequeue();
	public T front();
	public T back();
}

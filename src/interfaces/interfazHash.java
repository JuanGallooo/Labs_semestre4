package interfaces;

public interface interfazHash<T> {
	public int hashFunctionCarsBigger100(T object);
	public int hashFunctionCarsLess100(T object);
	public T get(T key);
	public void addToTable( T object);
	public int size();
}

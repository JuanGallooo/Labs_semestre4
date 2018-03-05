package interfaces;

import mundo.Carro;

public interface interfazHash<T> {
	public int hashFunctionCarsBigger100(T object);
	public int hashFunctionCarsLess100(T object);
	public T replace(T object);
	public String[] values();
	public boolean containsKey(String key);
	public T Get(T key);
	public T remove(String key);
	public int size();
}

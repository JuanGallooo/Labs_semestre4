package mundo;

public interface interfazHash<T> {
	public String keySet(T object);
	public T replace(T object);
	public String[] values();
	public boolean containsKey(String key);
	public T Get(String key);
	public T remove(String key);
	public int size();
}

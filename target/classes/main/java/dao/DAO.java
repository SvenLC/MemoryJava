package dao;

public abstract class DAO<T> {

	public abstract boolean create(T obj);

	public abstract T read(int id);

	public abstract boolean update(T obj);

	public abstract boolean delete(T obj);

}
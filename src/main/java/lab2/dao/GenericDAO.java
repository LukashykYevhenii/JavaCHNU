package lab2.dao;

public interface GenericDAO<T, ID> {

    T getById(ID id);

    void save(T entity);

    void update(T entity);

    void remove(T entity);
}

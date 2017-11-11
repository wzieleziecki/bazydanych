package pl.edu.agh.bazydanych2017.dao;

import java.io.Serializable;

public interface GenericCrudDao<T, PK extends Serializable> {
    T create(T t);
    T read(PK id);
    T update(T t);
    void delete(T t);
}

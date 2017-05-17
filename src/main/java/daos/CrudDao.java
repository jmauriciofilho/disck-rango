package daos;

import models.Cliente;

import java.util.List;

/**
 * Created by mauricio on 15/05/17.
 */
public interface CrudDao<E> {

    void create(E e);

    void update(E e);

    void delete(int i);

    E find(String s);

    List<E> all();
}

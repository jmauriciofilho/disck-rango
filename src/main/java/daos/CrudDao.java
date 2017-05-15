package daos;

import models.Cliente;

/**
 * Created by mauricio on 15/05/17.
 */
public interface CrudDao<E> {

    void create(E e);

    void update(E e);

    void delete(int i);

    Object find(String s);

    Object[] all();
}

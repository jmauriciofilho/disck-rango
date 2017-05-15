package daos;

/**
 * Created by mauricio on 15/05/17.
 */
public interface CrudDao<E> {

    void create(E e);

    void update(E e);

    void delete(E e);

    void find(E e);

    void all();
}

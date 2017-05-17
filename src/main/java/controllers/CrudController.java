package controllers;

import java.util.List;

/**
 * Created by mauricio on 17/05/17.
 */
public interface CrudController<E>{

    String create(E e);

    String update(E e);

    String delete(int i);

    E find(String s);

    List<E> all();
}

package com.comercioonline.interfaces;

import java.util.List;

public interface CrudInterface<T, ID> {

    List<T> findAll();

    T findById(ID id);

    T save(T entity); // ← Corregido: quitamos el ID

    T update(ID id, T entity); // ← También corrijo "uptdate" → "update"

    void deleteById(ID id);
}

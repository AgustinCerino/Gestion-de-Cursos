package org.example.Interfaces;

import org.example.Exceptions.SoloNumerosException;

public interface RepositoryGeneric<K, V> {
    void registrar(V obj);
    V consultar(K id) throws SoloNumerosException;
    void actualizar(K id, V obj);
    void eliminar(K id);
}

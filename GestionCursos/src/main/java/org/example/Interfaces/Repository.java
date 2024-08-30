package org.example.Interfaces;

import org.example.Exceptions.SoloNumerosException;

public interface Repository <T> {
    void registrar(T obj);
    T consultar(String id) throws SoloNumerosException;
    void actualizar(String id, T obj);
    void eliminar(String id);

}

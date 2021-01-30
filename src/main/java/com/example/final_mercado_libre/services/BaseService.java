package com.example.final_mercado_libre.services;

public interface BaseService <E>{
    public E save (E entity) throws Exception;
    public boolean delete(Long id) throws Exception;
}

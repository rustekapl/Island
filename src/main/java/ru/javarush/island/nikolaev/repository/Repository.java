package ru.javarush.island.nikolaev.repository;

public interface Repository<T> {

    T find(String name);

    void save(String name, T entity);

}

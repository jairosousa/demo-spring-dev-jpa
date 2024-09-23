package com.jnsdev.demospringdevjpa.dao;

import com.jnsdev.demospringdevjpa.entity.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 * @Autor Jairo Nascimento
 * @Created 23/09/2024 - 09:50
 */
@Repository
public class AutorDao {

    @PersistenceContext
    private EntityManager manager;

    public void save(Autor autor) {
        this.manager.persist(autor);
    }
}

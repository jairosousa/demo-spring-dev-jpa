package com.jnsdev.demospringdevjpa.dao;

import com.jnsdev.demospringdevjpa.entity.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Autor Jairo Nascimento
 * @Created 23/09/2024 - 09:50
 */
@Repository
public class AutorDao {

    @PersistenceContext
    private EntityManager manager;

    @Transactional(readOnly = false)
    public void save(Autor autor) {
        this.manager.persist(autor);
    }
    @Transactional(readOnly = false)
    public void update(Autor autor) {
        this.manager.merge(autor);
    }

    @Transactional(readOnly = false)
    public void delete(Long idAutor) {
        this.manager.remove(this.manager.getReference(Autor.class, idAutor));
    }

    @Transactional(readOnly = true)
    public Autor findById(Long idAutor) {
        return this.manager.find(Autor.class, idAutor);
    }
}

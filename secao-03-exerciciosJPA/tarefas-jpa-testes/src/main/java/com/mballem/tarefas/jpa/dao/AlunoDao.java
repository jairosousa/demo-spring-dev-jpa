package com.mballem.tarefas.jpa.dao;

import com.mballem.tarefas.jpa.domain.Aluno;
import com.mballem.tarefas.jpa.domain.AlunoRepository;
import com.mballem.tarefas.jpa.projection.AlunoInfoProjection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public class AlunoDao {

    /**
     * TESTE 1 - Complete o metodo com a operação JPA solicitada
     */

    @Autowired
    private AlunoRepository repository;

    @PersistenceContext
    private EntityManager manager;

    @Transactional(readOnly = true)
    public Aluno findByNomeCompleto(String nome) {
        String query = """
                select a from Aluno a where a.nome like :nome
                """;

        return this.manager
                .createQuery(query, Aluno.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    /**
     * TESTE 2 - Complete o metodo com a operação JPA solicitada
     */
    @Transactional(readOnly = true)
    public Aluno findByMatricula(String matricula) {
        String query = """
                select a from Aluno a where a.matricula like :matricula
                """;

        return this.manager
                .createQuery(query, Aluno.class)
                .setParameter("matricula", matricula)
                .getSingleResult();
    }

    /**
     * TESTE 3 - Complete o metodo com a operação JPA solicitada
     */
    @Transactional(readOnly = true)
    public Long findByAnoLetivo(int inicio, int fim) {
        String query = """
                select count(a) from Aluno a where a.anoLetivo BETWEEN :inicio AND :fim
                """;

        return this.manager
                .createQuery(query, Long.class)
                .setParameter("inicio", inicio)
                .setParameter("fim", fim)
                .getSingleResult();

    }

    /**
     * TESTE 4 - Complete o metodo com a operação JPA solicitada
     */
    @Transactional(readOnly = true)
    public List<Aluno> findByNomeParcial(String nome) {
        String query = """
                select a from Aluno a where a.nome like :nome
                """;

        return this.manager
                .createQuery(query, Aluno.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<Aluno> findAll() {
        String query = """
                select a from Aluno a
                """;

        return this.manager
                .createQuery(query, Aluno.class)
                .getResultList();
    }

    /**
     * TESTE 5 - Complete o metodo com a operação JPA solicitada
     */
    @Transactional(readOnly = true)
    public Aluno findByNumeroArmario(Integer numero) {
        String query = """
                select a from Aluno a join a.armario ar where ar.numero = :numero
                """;

        return this.manager
                .createQuery(query, Aluno.class)
                .setParameter("numero", numero)
                .getSingleResult();
    }

    /**
     * TESTE 6 - Complete o metodo com a operação JPA solicitada
     */
    public List<Long> findByNumerosDeArmarios(List<Integer> numeros) {
        String query = """
                select a.id from Aluno a where a.armario.numero in(:numeros)
                """;

        return this.manager
                .createQuery(query, Long.class)
                .setParameter("numeros", numeros)
                .getResultList();
    }

    /**
     * TESTE 7 - Complete o metodo com a operação JPA solicitada
     */
    @Transactional
    public Aluno updateNomeById(String matricula, String nome) {
//        String jpql = """
//                update Aluno a SET a.nome = :novoNome WHERE a.matricula = :matricula
//                """;
//
//        this.manager
//                .createQuery(jpql)
//                .setParameter("novoNome", nome)
//                .setParameter("matricula", matricula)
//                .executeUpdate();
//        String jpqlSelect = "SELECT a FROM Aluno a WHERE a.matricula = :matricula";
//
//        return manager.createQuery(jpqlSelect, Aluno.class)
//                .setParameter("matricula", matricula)
//                .getSingleResult();

        Aluno aluno = findByMatricula(matricula);
        aluno.setNome(nome);
        return aluno;
    }

    /**
     * TESTE 8 - Complete o metodo com a operação JPA solicitada
     */
    public List<AlunoInfoProjection> findAlunosAndArmariosByNomeAndAnoLetivo(String nome, int anoLetivo) {

        String query = """
                select new AlunoInfoProjection(a.nome, a.armario.numero)
                from Aluno a
                where a.nome like :nome
                AND a.anoLetivo = :anoLetivo
                ORDER BY a.nome ASC
                """;
        return this.manager.createQuery(query, AlunoInfoProjection.class)
                .setParameter("nome", "%" + nome)
                .setParameter("anoLetivo", anoLetivo)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Aluno findById(Long id) {
        String query = """
                select a from Aluno a where a.id = :id
                """;

        return this.manager
                .createQuery(query, Aluno.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}

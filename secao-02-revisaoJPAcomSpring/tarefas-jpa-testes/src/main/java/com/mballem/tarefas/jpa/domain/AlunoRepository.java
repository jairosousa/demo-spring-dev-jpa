package com.mballem.tarefas.jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findByNome(String nome);
    Aluno findByMatricula(String matricula);
    List<Aluno> findByAnoLetivoBetween(Integer anoInicial, Integer anoFinal);

    List<Aluno> findByNomeContaining(String nomeParcial);
}
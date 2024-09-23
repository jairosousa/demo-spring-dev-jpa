package com.jnsdev.demospringdevjpa.controller;

import com.jnsdev.demospringdevjpa.dao.AutorDao;
import com.jnsdev.demospringdevjpa.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autor Jairo Nascimento
 * @Created 23/09/2024 - 09:54
 */
@RestController
@RequestMapping("autores")
public class AutorContrller {

    @Autowired
    private AutorDao autorDao;

    @PostMapping
    public Autor salvar(@RequestBody Autor autor) {
        autorDao.save(autor);
        return autor;
    }
}

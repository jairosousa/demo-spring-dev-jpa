package com.jnsdev.demospringdevjpa.controller;

import com.jnsdev.demospringdevjpa.dao.AutorDao;
import com.jnsdev.demospringdevjpa.entity.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Autor Jairo Nascimento
 * @Created 23/09/2024 - 09:54
 */
@RestController
@RequestMapping("autores")
public class AutorController {

    @Autowired
    private AutorDao dao;

    @PostMapping
    public Autor salvar(@RequestBody Autor autor) {
        dao.save(autor);
        return autor;
    }

    @PutMapping
    public Autor update(@RequestBody Autor autor) {
        dao.update(autor);
        return autor;
    }

    @DeleteMapping("{idAutor}")
    public String delete(@PathVariable Long idAutor) {
        dao.delete(idAutor);
        return String.format("Autor id: %s foi excluído com sucesso", idAutor);
    }

    @GetMapping("{idAutor}")
    public Autor getById(@PathVariable Long idAutor) {
        return dao.findById(idAutor);
    }
}

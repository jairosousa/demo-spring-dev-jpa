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
    private AutorDao autorDao;

    @PostMapping
    public Autor salvar(@RequestBody Autor autor) {
        autorDao.save(autor);
        return autor;
    }

    @PutMapping
    public Autor update(@RequestBody Autor autor) {
        autorDao.update(autor);
        return autor;
    }

    @DeleteMapping("{idAutor}")
    public String delete(@PathVariable Long idAutor) {
        autorDao.delete(idAutor);
        return String.format("Autor id: %s foi excluído com sucesso", idAutor);
    }
}

package com.jnsdev.demospringdevjpa.controller;

import com.jnsdev.demospringdevjpa.dao.AutorDao;
import com.jnsdev.demospringdevjpa.entity.Autor;
import com.jnsdev.demospringdevjpa.entity.InfoAutor;
import com.jnsdev.demospringdevjpa.projection.AutorInfoProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public List<Autor> findAll() {
        return dao.findAll();
    }

    @GetMapping("nomeOrSobrenome")
    public List<Autor> findAllByNameOrSobrenome(@RequestParam String termo) {
        return dao.findAllByNameOrSobrenome(termo);
    }

    @GetMapping("total")
    public Long getTotalAutores() {
        return dao.getTotalElement();
    }

    @PutMapping("{id}/info")
    public Autor salvarInfoAutor(@PathVariable Long id, @RequestBody InfoAutor infoAutor) {
        return dao.saveInfoAutor(infoAutor, id);
    }

    @GetMapping("info")
    public List<Autor> salvarInfoAutor(@RequestParam String cargo) {
        return dao.findByCargo(cargo);
    }

    @GetMapping("autor-info")
    public AutorInfoProjection salvarInfoAutor(@RequestParam Long id) {
        return dao.findAutorInfoById(id);
    }
}

package com.cinereview.cinereview_api.controller;

import com.cinereview.cinereview_api.dto.FilmeDTO;
import com.cinereview.cinereview_api.model.Filme;
import com.cinereview.cinereview_api.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeService service;

    @GetMapping
    public List<Filme> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Retorna 201 Created
    public Filme cadastrar(@RequestBody FilmeDTO dto) {
        return service.cadastrar(dto);
    }


    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }


    @PutMapping("/{id}")
    public Filme atualizar(@PathVariable Long id, @RequestBody FilmeDTO dto) {
//        Filme filmeExistente = repository.findById(id).orElseThrow();
//
//        filmeExistente.setTitulo(filmeAtualizado.getTitulo());
//        filmeExistente.setGenero(filmeAtualizado.getGenero());
//        filmeExistente.setAnoLancamento(filmeAtualizado.getAnoLancamento());
//        filmeExistente.setDiretor(filmeAtualizado.getDiretor());

        return service.atualizar(id, dto);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna 204 No Content
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}

package com.cinereview.cinereview_api.controller;

import com.cinereview.cinereview_api.model.Filme;
import com.cinereview.cinereview_api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeRepository repository;

    @GetMapping
    public List<Filme> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Retorna 201 Created
    public Filme cadastrar(@RequestBody Filme filme) {
        return repository.save(filme);
    }

    // 3. Buscar por ID (Read)
    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }
    // 4. Atualizar (Update) - Tópico 6.1: Verbo PUT
    @PutMapping("/{id}")
    public Filme atualizar(@PathVariable Long id, @RequestBody Filme filmeAtualizado) {
        Filme filmeExistente = repository.findById(id).orElseThrow();

        filmeExistente.setTitulo(filmeAtualizado.getTitulo());
        filmeExistente.setGenero(filmeAtualizado.getGenero());
        filmeExistente.setAnoLancamento(filmeAtualizado.getAnoLancamento());
        filmeExistente.setDiretor(filmeAtualizado.getDiretor());

        return repository.save(filmeExistente);
    }

    // 5. Deletar (Delete) - Tópico 6.1: Verbo DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna 204 No Content
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

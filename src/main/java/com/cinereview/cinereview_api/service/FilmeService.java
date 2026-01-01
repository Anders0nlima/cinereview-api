package com.cinereview.cinereview_api.service;

import com.cinereview.cinereview_api.dto.FilmeDTO;
import com.cinereview.cinereview_api.model.Filme;
import com.cinereview.cinereview_api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository repository;

    public List<Filme> listarTodos() {
        return repository.findAll();
    }

    public Filme cadastrar(FilmeDTO dto) {
        // Exemplo de regra de negócio: converter DTO para Entity
        Filme filme = new Filme();
        filme.setTitulo(dto.titulo());
        filme.setGenero(dto.genero());
        filme.setAnoLancamento(dto.anoLancamento());
        filme.setDiretor(dto.diretor());

        return repository.save(filme);
    }

    public Filme atualizar(Long id, FilmeDTO dto) {
        Filme filmeExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado!"));

        filmeExistente.setTitulo(dto.titulo());
        filmeExistente.setGenero(dto.genero());
        filmeExistente.setAnoLancamento(dto.anoLancamento());
        filmeExistente.setDiretor(dto.diretor());

        return repository.save(filmeExistente);
    }

    public Filme buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Filme com ID " + id + " não encontrado!"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

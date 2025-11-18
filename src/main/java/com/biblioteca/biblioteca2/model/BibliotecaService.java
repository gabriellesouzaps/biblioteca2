package com.biblioteca.biblioteca2.model;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {

    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        return livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado."));
    }

    public void emprestarLivro(String titulo) {
        Livro livro = buscarLivroPorTitulo(titulo);
        livro.emprestar();
    }

    public void devolverLivro(String titulo) {
        Livro livro = buscarLivroPorTitulo(titulo);
        livro.devolver();
    }

    public List<Livro> listarLivros() {
        return livros;
    }
}


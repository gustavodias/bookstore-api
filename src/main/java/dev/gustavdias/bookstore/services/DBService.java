package dev.gustavdias.bookstore.services;

import dev.gustavdias.bookstore.domain.Categoria;
import dev.gustavdias.bookstore.domain.Livro;
import dev.gustavdias.bookstore.repository.CategoriaRepository;
import dev.gustavdias.bookstore.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    private final CategoriaRepository categoriaRepository;
    private final LivroRepository livroRepository;

    public DBService(CategoriaRepository categoriaRepository,
                     LivroRepository livroRepository) {
        this.categoriaRepository = categoriaRepository;
        this.livroRepository = livroRepository;
    }

    public void instaciaBaseDeDados(){
        Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
        Categoria cat2 = new Categoria(null, "Ficcão Cientifica", "Ficção Cientifica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

        Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsu,", cat1);
        Livro l2 = new Livro(null, "Engenharia de Software", "Louis V.", "Lorem ipsu,", cat1);
        Livro l3 = new Livro(null, "The Time Machine", "H.G. Wells", "Lorem ipsu,", cat2);
        Livro l4 = new Livro(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsu,", cat2);
        Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsu,", cat2);

        cat1.getLivros().addAll(Arrays.asList(l1,l2));
        cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));

        this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
    }

}

package dev.gustavdias.bookstore.services;

import dev.gustavdias.bookstore.domain.Livro;
import dev.gustavdias.bookstore.repository.LivroRepository;
import dev.gustavdias.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro findById(Integer id){
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:"+ id+", Tipo:"+Livro.class.getName()));
    }


}

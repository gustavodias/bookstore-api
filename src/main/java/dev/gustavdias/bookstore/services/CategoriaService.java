package dev.gustavdias.bookstore.services;

import dev.gustavdias.bookstore.domain.Categoria;
import dev.gustavdias.bookstore.repository.CategoriaRepository;
import dev.gustavdias.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não Encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName()));
    }
}

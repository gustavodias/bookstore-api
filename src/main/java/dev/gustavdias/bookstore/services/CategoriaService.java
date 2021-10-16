package dev.gustavdias.bookstore.services;

import dev.gustavdias.bookstore.domain.Categoria;
import dev.gustavdias.bookstore.dtos.CategoriaDTO;
import dev.gustavdias.bookstore.repository.CategoriaRepository;
import dev.gustavdias.bookstore.services.exceptions.DataIntegrityViolationException;
import dev.gustavdias.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria atualizar(Integer id, CategoriaDTO objDto) {
        Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer id){
        findById(id);
        try {
          repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Categoria não pode ser deletado! Possui Livros associados.");
        }
    }
}

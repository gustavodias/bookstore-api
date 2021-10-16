package dev.gustavdias.bookstore.dtos;

import dev.gustavdias.bookstore.domain.Livro;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class LivroDTO implements Serializable {
    private Integer id;
    @NotEmpty(message = "O Campo titulo é requirido")
    @Length(min = 3, max = 50, message = "O campo titulo deve ter entre 3 a 50 caracteres.")
    private String titulo;

    public LivroDTO() {
        super();
    }

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

package dev.gustavdias.bookstore.dtos;

import dev.gustavdias.bookstore.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "O Campo nome é requirido")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 a 100 caracteres.")
    private String nome;

    @NotEmpty(message = "O Campo descricao é requirido")
    @Length(min = 3, max = 200, message = "O campo descricao deve ter entre 3 a 200 caracteres.")
    private String descricao;

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

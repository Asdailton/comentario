package com.happdine.comentario.models;


import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Table(name = "coments")
@Entity
public class ComentModel extends RepresentationModel<ComentModel> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "opcao", nullable = false)
    private Opcao opcao;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "timestampp", nullable = false)
    private String timestampp;

    @Column(name = "estrela", nullable = false)
    private Integer estrela;

    @Column(name = "isAprovado", nullable = false)
    private boolean isAprovado;

    @Column(name = "corEstrela", nullable = false)
    private String corEstrela;

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Opcao getOpcao() {
        return opcao;
    }

    public void setOpcao(Opcao opcao) {
        this.opcao = opcao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTimestampp() {
        return timestampp;
    }

    public void setTimestampp(String timestampp) {
        this.timestampp = timestampp;
    }

    public Integer getEstrela() {
        return estrela;
    }

    public void setEstrela(Integer estrela) {
        this.estrela = estrela;
    }

    public boolean isAprovado() {
        return isAprovado;
    }

    public void setAprovado(boolean aprovado) {
        isAprovado = aprovado;
    }

    public  String getCorEstrela(){
        return this.corEstrela;
    }

    public void setCorEstrela(String corEstrela) {
        this.corEstrela = corEstrela;
    }


    public void setIsAprovado(boolean aprovado) {
        this.isAprovado = aprovado;
    }
}


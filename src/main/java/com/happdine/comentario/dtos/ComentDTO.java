package com.happdine.comentario.dtos;


import com.happdine.comentario.models.Opcao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ComentDTO(
        @NotNull @NotBlank String nome,
        @NotNull Opcao opcao,
        @NotNull @NotBlank String comentario,
        @NotNull @NotBlank String timestampp,
        @NotNull Integer estrela,
        @NotNull @NotBlank String cor_estrela,
        @NotNull  boolean isAprovado

) {
}

package com.happdine.comentario.services;

import com.happdine.comentario.dtos.ComentDTO;
import com.happdine.comentario.models.ComentModel;
import com.happdine.comentario.models.Opcao;
import com.happdine.comentario.repositories.ComentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServices {
    @Autowired
    private ComentRepository comentRepository;

    public List<ComentModel> findAllByWebsite(){
        return comentRepository.findAll().stream()
                .filter(coment -> coment.getOpcao() == Opcao.WEBSITE)
                .collect(Collectors.toList());
    }

    public List<ComentModel> findAllByRestaurante(){
        return comentRepository.findAll().stream()
                .filter(coment -> coment.getOpcao() == Opcao.RESTAURANTE)
                .collect(Collectors.toList());

    }

    public ComentDTO atualizarStatus(ComentDTO comentDTO, long id) throws Exception {
        Optional<ComentModel> entityOptional = comentRepository.findById(id);

        if (entityOptional.isEmpty()) {
            throw new Exception("O comentário com esse id não existe");
        }

        // Atualizando a entidade e salvando no repositório
        ComentModel entity = entityOptional.get();
        entity.setIsAprovado(comentDTO.isAprovado()); // Ajustando status

        // Salvando a entidade atualizada
        comentRepository.save(entity);

        // Retornando o DTO atualizado
        return new ComentDTO(
                entity.getNome(),
                entity.getOpcao(),
                entity.getComentario(),
                entity.getTimestampp(),
                entity.getEstrela(),
                entity.getCorEstrela(),
                entity.isAprovado()
        );
    }

}

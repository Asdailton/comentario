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
public class ComentServices {
    @Autowired
    private ComentRepository comentRepository;

    public List<ComentModel> findAllByWebSite() {
        // Retorna todos os comentários com a opção WEBSITE
        return comentRepository.findAll().stream()
                .filter(coment -> coment.getOpcao() == Opcao.WEBSITE && coment.isAprovado())
                .collect(Collectors.toList());
    }

    public List<ComentModel> findAllByRestaurante() {
        // Retorna todos os comentários com a opção RESTAURANTE
        return comentRepository.findAll().stream()
                .filter(coment -> coment.getOpcao() == Opcao.RESTAURANTE && coment.isAprovado())
                .collect(Collectors.toList());
    }



    public ComentDTO createComent(ComentDTO comentDTO) {
        ComentModel entity = new ComentModel();

        // Mapear manualmente todos os campos
        entity.setNome(comentDTO.nome());
        entity.setOpcao(comentDTO.opcao());
        entity.setAprovado(false);
        entity.setComentario(comentDTO.comentario());
        entity.setTimestampp(comentDTO.timestampp());
        entity.setEstrela(comentDTO.estrela());
        entity.setCorEstrela(comentDTO.cor_estrela());



        // Salvar a entidade no repositório
        ComentModel savedEntity = comentRepository.save(entity);

        // Retornar o DTO com os dados salvos
        return new ComentDTO(
                savedEntity.getNome(),
                savedEntity.getOpcao(),
                savedEntity.getComentario(),
                savedEntity.getTimestampp(),
                savedEntity.getEstrela(),
                savedEntity.getCorEstrela(),
                savedEntity.isAprovado()
        );
    }}


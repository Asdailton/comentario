package com.happdine.comentario.controllers;

import com.happdine.comentario.dtos.ComentDTO;
import com.happdine.comentario.models.ComentModel;
import com.happdine.comentario.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comentarios/admin")
public class AdminController {
    @Autowired
    private AdminServices service;

    //Url para faze o GET dos comentários do Restaurante na seção admin
    @GetMapping(value="/restaurante", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ComentModel>>findAllByRestaurante() throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllByRestaurante());
    }

    //Url para fazer o GET dos comentários do Website na seção admin
    @GetMapping(value="/website", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ComentModel>>findAllByWebsite() throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllByWebsite());

    }

    //Url para fazer o PUT dos comentários (GERAL) da seção admin
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComentDTO> update(@PathVariable Long id, @RequestBody ComentDTO comentDTO) throws Exception {
        ComentDTO updatedComment = service.atualizarStatus(comentDTO, id);
        return ResponseEntity.ok(updatedComment);
    }

}

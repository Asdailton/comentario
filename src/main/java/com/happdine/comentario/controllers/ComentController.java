package com.happdine.comentario.controllers;

import com.happdine.comentario.dtos.ComentDTO;
import com.happdine.comentario.models.ComentModel;
import com.happdine.comentario.services.ComentServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comentarios")
public class ComentController {
    @Autowired
    private ComentServices service;

    //Url para fazer o GET dos comentários do Restaurante
    @GetMapping(value="/restaurante", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ComentModel>>findAllByRestaurante() throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllByRestaurante());
    }
    //Url para fazer o GET dos comentários do Website
    @GetMapping(value="/website", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ComentModel>>findAllByWebsite() throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllByWebSite());
    }
    //Url para fazer o POST dos comentários
    @PostMapping(value="/create-coment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody @Valid ComentDTO coment) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createComent((coment)));
    }


}

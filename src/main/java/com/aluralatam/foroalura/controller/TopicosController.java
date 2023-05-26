package com.aluralatam.foroalura.controller;

import com.aluralatam.foroalura.domain.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public ResponseEntity<List<DatosRespuestaTopico>> listaTopicos() {
        List<DatosRespuestaTopico> lista = topicoRepository.findAll()
                .stream()
                .map(topico -> topicoService.mapRespuestaTopico(topico))
                .toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> topicoById(@PathVariable("id") Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(topicoService.mapRespuestaTopico(topico));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
        Topico topico = new Topico(datosRegistroTopico);
        topicoRepository.save(topico);
        return ResponseEntity.ok(topicoService.mapRespuestaTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> borrarTopico(@PathVariable("id") Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.ok(topicoService.mapRespuestaTopico(topico));
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(topicoService.mapRespuestaTopico(topico));
    }
}

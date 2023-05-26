package com.aluralatam.foroalura.domain.topicos;

import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    public DatosRespuestaTopico mapRespuestaTopico(Topico topico) {
        return new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getEstatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}

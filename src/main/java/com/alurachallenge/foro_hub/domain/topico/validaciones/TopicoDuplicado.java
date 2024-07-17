package com.alurachallenge.foro_hub.domain.topico.validaciones;

import com.alurachallenge.foro_hub.domain.topico.DatosTopico;
import com.alurachallenge.foro_hub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoDuplicado implements ValidadorDeTopicos {
    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DatosTopico datosTopico) {
        var topico = topicoRepository.findTopicoDuplicado(datosTopico.titulo(), datosTopico.mensaje());
        if (!topico.isEmpty()) {
            throw new ValidationException("El topico ya se encutra registrado");
        }
    }
}

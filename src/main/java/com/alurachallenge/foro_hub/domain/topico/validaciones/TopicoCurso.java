package com.alurachallenge.foro_hub.domain.topico.validaciones;

import com.alurachallenge.foro_hub.domain.curso.CursoRepository;
import com.alurachallenge.foro_hub.domain.topico.DatosTopico;
import com.alurachallenge.foro_hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoCurso implements ValidadorDeTopicos {
    @Autowired
    CursoRepository cursoRepository;

    public void validar(DatosTopico datosTopico) {
        if (!cursoRepository.findById(datosTopico.idCurso()).isPresent()) {
            throw new ValidacionDeIntegridad("Curso no encontrado");
        }
    }
}

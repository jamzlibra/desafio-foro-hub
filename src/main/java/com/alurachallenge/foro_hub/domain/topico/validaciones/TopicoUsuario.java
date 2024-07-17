package com.alurachallenge.foro_hub.domain.topico.validaciones;

import com.alurachallenge.foro_hub.domain.topico.DatosTopico;
import com.alurachallenge.foro_hub.domain.usuario.UsuarioRepository;
import com.alurachallenge.foro_hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoUsuario implements ValidadorDeTopicos {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(DatosTopico datosTopico){
        if (!usuarioRepository.findById(datosTopico.idUsuario()).isPresent()) {
            throw new ValidacionDeIntegridad("Usuario no encontrado");
        }
    }
}

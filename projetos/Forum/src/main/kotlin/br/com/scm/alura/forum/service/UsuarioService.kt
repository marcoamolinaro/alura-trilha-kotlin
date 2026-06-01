package br.com.scm.alura.forum.service

import br.com.scm.alura.forum.model.Usuario
import br.com.scm.alura.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
data class UsuarioService(
    private val usuarioRepository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.findById(id).orElseThrow()
    }
}

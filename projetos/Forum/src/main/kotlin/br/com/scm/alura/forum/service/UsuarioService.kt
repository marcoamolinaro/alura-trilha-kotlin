package br.com.scm.alura.forum.service

import br.com.scm.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
data class UsuarioService(
    var usuarios: List<Usuario> = ArrayList()
) {
    init {
        val usuario = Usuario (
            id = 1,
            nome = "Usuario 1",
            email = "usuario1@email.com")
        usuarios = listOf(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.find { it.id == id }!!
    }
}

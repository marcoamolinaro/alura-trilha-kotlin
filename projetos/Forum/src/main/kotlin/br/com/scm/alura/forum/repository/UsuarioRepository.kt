package br.com.scm.alura.forum.repository

import br.com.scm.alura.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
}
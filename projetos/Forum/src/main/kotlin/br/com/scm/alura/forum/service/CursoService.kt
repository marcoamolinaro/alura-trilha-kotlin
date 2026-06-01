package br.com.scm.alura.forum.service

import br.com.scm.alura.forum.model.Curso
import br.com.scm.alura.forum.model.Usuario
import br.com.scm.alura.forum.repository.CursoRepository
import br.com.scm.alura.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class CursoService (
    private val cursoRepository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return cursoRepository.findById(id).orElseThrow()
    }
}
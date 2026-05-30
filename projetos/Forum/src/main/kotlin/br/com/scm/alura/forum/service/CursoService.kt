package br.com.scm.alura.forum.service

import br.com.scm.alura.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class CursoService (
    var cursos: List<Curso>) {

    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programacao"
        )
        cursos = listOf(curso)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.find { it.id == id }!!
    }
}
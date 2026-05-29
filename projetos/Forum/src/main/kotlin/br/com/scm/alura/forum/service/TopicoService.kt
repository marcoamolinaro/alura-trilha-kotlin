package br.com.scm.alura.forum.service

import br.com.scm.alura.forum.model.Curso
import br.com.scm.alura.forum.model.Topico
import br.com.scm.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico>
) {

    init {
        val topico1 = Topico(
            1,
            titulo = "Duvida sobre Spring Boot",
            mensagem = "Alguem pode me ajudar com Spring Boot?",
            curso = Curso(
                1,
                nome = "Duvida sobre Spring Boot",
                categoria = "Programação",
            ),
            autor = Usuario(
                1,
                nome = "Marco",
                email = "marco@email.com"
            )
        )

        val topico2 = Topico(
            2,
            titulo = "Duvida sobre controller",
            mensagem = "Alguem pode me ajudar com controller?",
            curso = Curso(
                1,
                nome = "Duvida sobre Spring Boot",
                categoria = "Programação",
            ),
            autor = Usuario(
                2,
                nome = "Carmen",
                email = "carmen@email.com"
            )
        )

        val topico3 = Topico(
            3,
            titulo = "Duvida sobre Kotlin",
            mensagem = "Alguem pode me ajudar com construtores?",
            curso = Curso(
                2,
                nome = "Duvida sobre Kotlin",
                categoria = "Programação",
            ),
            autor = Usuario(
                3,
                nome = "Sofia",
                email = "sofia@email.com"
            )
        )

        topicos = listOf(topico1, topico2, topico3)
    }

    fun listar() : List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long) : Topico? {
        return topicos.find { it.id == id }
    }
}
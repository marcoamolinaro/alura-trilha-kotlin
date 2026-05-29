package br.com.scm.alura.forum.controller

import br.com.scm.alura.forum.model.Curso
import br.com.scm.alura.forum.model.Topico
import br.com.scm.alura.forum.model.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController {

    @GetMapping
    fun listas() : List<Topico> {
        val topico = Topico(
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

        return listOf(topico, topico, topico)
    }
}
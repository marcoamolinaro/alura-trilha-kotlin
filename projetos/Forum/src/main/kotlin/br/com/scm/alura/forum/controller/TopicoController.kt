package br.com.scm.alura.forum.controller

import br.com.scm.alura.forum.model.Topico
import br.com.scm.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val topicoService: TopicoService
) {

    @GetMapping
    fun listas() : List<Topico> {

        return topicoService.listar()
    }
}
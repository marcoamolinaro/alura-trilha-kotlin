package br.com.scm.alura.forum.controller

import br.com.scm.alura.forum.dto.TopicoAtualizarForm
import br.com.scm.alura.forum.dto.TopicoForm
import br.com.scm.alura.forum.dto.TopicoView
import br.com.scm.alura.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val topicoService: TopicoService
) {

    @GetMapping
    fun listas() : List<TopicoView> {
        return topicoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long) : TopicoView? {
        return topicoService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid form: TopicoForm) {
        topicoService.cadastrar(form)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: TopicoAtualizarForm) {
        topicoService.atualizar(form)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        topicoService.deletar(id)
    }
}
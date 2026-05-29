package br.com.scm.alura.forum.service

import br.com.scm.alura.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList()) {

    fun listar() : List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long) : Topico? {
        return topicos.find { it.id == id }
    }

    fun cadastrar(topico: Topico) {
        topicos = topicos.plus(topico)
    }
}
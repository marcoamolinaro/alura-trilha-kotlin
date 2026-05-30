package br.com.scm.alura.forum.service

import br.com.scm.alura.forum.dto.TopicoAtualizarForm
import br.com.scm.alura.forum.dto.TopicoForm
import br.com.scm.alura.forum.dto.TopicoView
import br.com.scm.alura.forum.mapper.TopicoFormMapper
import br.com.scm.alura.forum.mapper.TopicoViewMapper
import br.com.scm.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
) {

    fun listar() : List<TopicoView> {
        return topicos.stream().map{
            t -> TopicoViewMapper().map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long) : TopicoView? {
        val topico =  topicos.find { it.id == id }
        return topicoViewMapper.map(topico!!)
    }

    fun cadastrar(form: TopicoForm) {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }

    fun atualizar(form: TopicoAtualizarForm) {
        val topico = topicos.find { it.id == form.id }
            ?: throw RuntimeException("Topico não encontrado")
        topicos = topicos.minus(topico).plus(Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            curso = topico.curso,
            autor = topico.autor,
            status = topico.status,
            dataCriacao = topico.dataCriacao,
            respostas = topico.respostas
        ))
    }

    fun deletar(id: Long) {
        val topico = topicos.find { it.id == id }
            ?: throw RuntimeException("Topico não encontrado")
        topicos = topicos.minus(topico)
    }
}